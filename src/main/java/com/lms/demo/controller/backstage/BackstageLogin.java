package com.lms.demo.controller.backstage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lms.demo.model.LoginLog;
import com.lms.demo.model.Teacher;
import com.lms.demo.service.TeacherService;

@Controller
public class BackstageLogin {
	
	@Autowired
	TeacherService teacherService;
	
	@PostMapping("/backstage/login")
	public String login(HttpServletRequest req,Model model) {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		LoginLog loginLog=teacherService.login(email, password);
		if("0".equals(loginLog.getTeacher().getStatus())&&"0".equals(loginLog.getStatus())) {
			model.addAttribute("LoginLog", loginLog);
			return "makecourse";
		}
		
		return "adminlogin";
		
	}
	
	

}
