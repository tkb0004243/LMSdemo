package com.lms.demo.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.lms.demo.model.Student;
import com.lms.demo.model.StudentSignUpLog;
import com.lms.demo.service.student.StudentSignUpService;
import com.lms.demo.util.VertifyRegexUtil;

@Service
public class StudentSignUpServiceImpl implements StudentSignUpService {

	
	public StudentSignUpLog vertifySignUp(Student newstudent) {
		StudentSignUpLog studentSignUpLog=new StudentSignUpLog();
		String message="";
		if(!VertifyRegexUtil.matchEmailRegex(newstudent.getEmail())) {
			message+="名字格式有誤或空白";
		}
		if(!VertifyRegexUtil.matchNameRegex(newstudent.getName())) {
			message+="名字格式有誤或空白 ";
		}
		if(!VertifyRegexUtil.matchPwdRegex(newstudent.getPassword())) {
			message+="密碼格式有誤或空白";
		}
		if("".equals(message)) { //0:正常 1:異常
			studentSignUpLog.setStatus("0");
			return studentSignUpLog;
		}
		studentSignUpLog.setStatus("1"); //0:正常 1:異常
		studentSignUpLog.setMessage(message);
		return studentSignUpLog;
		
		
	}

}
