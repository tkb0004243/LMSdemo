package com.lms.demo.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.lms.demo.model.LoginLog;
import com.lms.demo.model.Student;
import com.lms.demo.service.StudentSignUpService;
import com.lms.demo.util.VertifyRegexUtil;

@Service
public class StudentSignUpServiceImpl implements StudentSignUpService {

	@Override
	public LoginLog vertifySignUp(Student newstudent) {
		LoginLog loginlog=new LoginLog();
		String message="";
		if(!VertifyRegexUtil.matchEmailRegex(newstudent.getStudent_email())) {
			message+="名字格式有誤或空白";
		}
		if(!VertifyRegexUtil.matchNameRegex(newstudent.getName())) {
			message+="名字格式有誤或空白 ";
		}
		if(!VertifyRegexUtil.matchPwdRegex(newstudent.getPassword())) {
			message+="密碼格式有誤或空白";
		}
		if("".equals(message)) {
			loginlog.setStatus(0);
			return loginlog;
		}
		loginlog.setStatus(1);
		loginlog.setMessage(message);
		return loginlog;
		
		
	}

}
