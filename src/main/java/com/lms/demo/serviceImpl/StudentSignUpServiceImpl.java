package com.lms.demo.serviceImpl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.lms.demo.model.Student;
import com.lms.demo.model.log.StudentSignUpLog;
import com.lms.demo.repository.StudentRepository;
import com.lms.demo.service.student.StudentSignUpService;
import com.lms.demo.util.VertifyCodeMake;
import com.lms.demo.util.VertifyRegexUtil;

@Service
public class StudentSignUpServiceImpl implements StudentSignUpService {
	
	@Autowired
	StudentRepository studentRepository;

	
	public StudentSignUpLog vertifySignUp(Student newstudent) { //0:正常 1:異常
		StudentSignUpLog studentSignUpLog=new StudentSignUpLog();
		
		if(!VertifyRegexUtil.matchEmailRegex(newstudent.getEmail())) {
			studentSignUpLog.setMessage("信箱格式有誤或空白");
			studentSignUpLog.setStatus("1");
		}
		if(!VertifyRegexUtil.matchNameRegex(newstudent.getName())) {
			studentSignUpLog.setMessage("名字格式有誤或空白");
			studentSignUpLog.setStatus("1");
		}
		if(!VertifyRegexUtil.matchPwdRegex(newstudent.getPassword())) {
			studentSignUpLog.setMessage("密碼格式有誤或空白");
			studentSignUpLog.setStatus("1");
		}
		
		
		if(studentSignUpLog.getStatus()==null) {
			studentSignUpLog.setNew_student(newstudent);
			studentSignUpLog.setStatus("0"); 
			studentSignUpLog.setMessage("會員資料驗證通過 ");
		}
		return studentSignUpLog;
	}

	@Override
	public StudentSignUpLog add(StudentSignUpLog studentSignUpLog) {
		Timestamp ts = new Timestamp(System.currentTimeMillis()); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String dateStringParse = sdf.format(date);
		ts=Timestamp.valueOf(dateStringParse);
		Student newstudent=studentSignUpLog.getNew_student();
		newstudent.setVertify_email_time(ts.toString()); //設置驗證時間
		newstudent.setAuthorities("student"); //設置權限
		newstudent.setStatus("1"); //設置狀態 0:正常 1:未驗證
		newstudent.setVertify_code(VertifyCodeMake.returnVertifyCode()); //設置驗證碼
		
		studentRepository.save(newstudent); //存入資料庫
		
		studentSignUpLog.setNew_student(newstudent);
		
		return studentSignUpLog;
	}

}
