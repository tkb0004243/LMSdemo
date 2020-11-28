package com.lms.demo.controller.admin.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.lms.demo.model.Teacher;
import com.lms.demo.model.TeacherLoginLog;
import com.lms.demo.service.teacher.TeacherService;

@Controller
public class BackstageLogin {
	
	@Autowired
	TeacherService teacherService;
	
	@PostMapping("/backstage/login")
	public String login(HttpServletRequest req,Model model) {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		TeacherLoginLog teacherLoginLog=teacherService.login(email, password);
		if("0".equals(teacherLoginLog.getTeacher().getStatus())&&"0".equals(teacherLoginLog.getStatus())) {
			model.addAttribute("teacherLoginLog", teacherLoginLog);
			return "makecourse";
		}
		
		return "adminlogin";
		
	}
	
	

}
