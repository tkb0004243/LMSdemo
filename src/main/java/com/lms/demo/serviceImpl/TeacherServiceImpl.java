package com.lms.demo.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.LoginLog;
import com.lms.demo.model.log.SignUpLog;
import com.lms.demo.repository.TeacherRepository;
import com.lms.demo.service.mail.VertifyMailService;
import com.lms.demo.service.teacher.TeacherService;
import com.lms.demo.util.VertifyCodeMake;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	VertifyMailService vertifyMailService;
	
	public LoginLog login(String email,String password) {
		LoginLog teacherloginLog=new LoginLog();
		List<Teacher> result=teacherRepository.findByEmail(email);
		
		if(result!=null&&!result.isEmpty()) {
			Teacher vertify_ty=result.get(0);
			if(vertify_ty.getPassword().equals(password)) {
				teacherloginLog.setStatus("0");
				teacherloginLog.setMessage("登入成功");
				teacherloginLog.setTeacher(vertify_ty);
				teacherloginLog.setAuthority("teacher");
				return teacherloginLog;
			}
			teacherloginLog.setStatus("1");
			teacherloginLog.setMessage("密碼錯誤");
			return teacherloginLog;
			
			
		}
		teacherloginLog.setStatus("1");
		teacherloginLog.setMessage("未註冊帳號");
		return teacherloginLog;
	}

	public void signup(Teacher teacher) {
		teacher.setStatus("1");
		teacher.setAuthorities("teacher");
		teacher.setVertify_code(VertifyCodeMake.returnVertifyCode());
		teacherRepository.save(teacher);
	}

	@Override
	public SignUpLog getmail(List<Teacher> result,HttpServletRequest request) throws ParseException {
		SignUpLog  teacherSignUpLog=  new  SignUpLog();
		if(result!=null) {
			String vertifycode=request.getParameter("vertifycode");
			Teacher result_ts=result.get(0);
			String trans_ts=result_ts.getVertify_time();
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date ver_date=sdf.parse(trans_ts);
			Date today=new Date();
			long from=today.getTime();
			long to=ver_date.getTime();
			long gap=from-to;
			
			if(result_ts.getVertify_code().equals(vertifycode)&&gap<(1000*60*60)) 
			{
			Teacher finish=result.get(0);
			finish.setStatus("0");
			teacherRepository.save(finish);
			teacherSignUpLog.setStatus("0");
			teacherSignUpLog.setMessage("驗證成功");
			teacherSignUpLog.setTeacher(finish);
			teacherSignUpLog.setAuthority("teacher");
			return teacherSignUpLog;
			
			}
			
			else {
				teacherSignUpLog.setStatus("1");
				teacherSignUpLog.setMessage("驗證超時,重新寄發驗證信");
				return teacherSignUpLog;
			}
			
		}
		
		teacherSignUpLog.setStatus("1");
		teacherSignUpLog.setMessage("查無此帳號,請重新註冊");
		return teacherSignUpLog;
	}

}
