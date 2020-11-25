package com.lms.demo.controller.student;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.demo.model.StudentLoginLog;
import com.lms.demo.service.student.StudentLoginService;

@Controller
public class LoginController {

	@Autowired
	StudentLoginService studentLoginService;
	
	
	@PostMapping("/login")
	public String login(@RequestParam("account")String account,@RequestParam("password")String password,HttpSession session) {
		
		StudentLoginLog studentLoginLog=studentLoginService.checkLogin(account, password);
		
		if("0".equals(studentLoginLog.getStatus())){ //0:正常 1：異常
			session.setAttribute("user_information", studentLoginLog);
			System.out.println(studentLoginLog.getStudent().getName());
			return "user";
		}
		else {
			session.setAttribute("error", studentLoginLog);
			return "login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		StudentLoginLog studentLoginLog=new StudentLoginLog();
		studentLoginLog.setMessage("已登出");
		session.setAttribute("user_information", studentLoginLog);
		return "login";
		
	}
	
	
	
	
	
	
}
