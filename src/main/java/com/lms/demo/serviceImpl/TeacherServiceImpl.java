package com.lms.demo.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.TeacherLoginLog;
import com.lms.demo.model.log.TeacherSignUpLog;
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
	
	public TeacherLoginLog login(String email,String password) {
		TeacherLoginLog loginLog=new TeacherLoginLog();
		List<Teacher> result=teacherRepository.findByEmail(email);
		
		if(result!=null&&!result.isEmpty()) {
			Teacher vertify_ty=result.get(0);
			if(vertify_ty.getPassword().equals(password)) {
				loginLog.setStatus("0");
				loginLog.setMessage("登入成功");
				loginLog.setTeacher(vertify_ty);
				return loginLog;
			}
			loginLog.setStatus("1");
			loginLog.setMessage("密碼錯誤");
			return loginLog;
			
			
		}
		loginLog.setStatus("1");
		loginLog.setMessage("未註冊帳號");
		return loginLog;
	}

	public void signup(Teacher teacher) {
		teacher.setStatus("1");
		teacher.setAuthorities("teacher");
		teacher.setVertify_code(VertifyCodeMake.returnVertifyCode());
		teacherRepository.save(teacher);
	}

	@Override
	public TeacherSignUpLog getmail(List<Teacher> result,HttpServletRequest request) throws ParseException {
		TeacherSignUpLog  teacherSignUpLog=  new  TeacherSignUpLog();
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
