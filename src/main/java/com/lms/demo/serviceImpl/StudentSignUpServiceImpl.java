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
	public boolean vertifySignUp(Student newstudent, Model model) {
		LoginLog loginlog=new LoginLog();
		String msg="";
		if(!VertifyRegexUtil.matchEmailRegex(newstudent.getStudent_email())) {
			msg+="名字格式有誤或空白";
		}
		if(!VertifyRegexUtil.matchNameRegex(newstudent.getName())) {
			msg+="名字格式有誤或空白 ";
		}
		if(!VertifyRegexUtil.matchPwdRegex(newstudent.getPassword())) {
			msg+="密碼格式有誤或空白";
		}
		if("".equals(msg)) {
			
			return true;
		}
		model.addAttribute("message", msg);
		return false;
		
		
	}

}
