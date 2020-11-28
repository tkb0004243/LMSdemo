package com.lms.demo.controller.student;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.demo.model.StudentLoginLog;
import com.lms.demo.service.student.StudentLoginService;

@Controller
@RequestMapping(value="/student",method= {RequestMethod.GET,RequestMethod.POST})
public class LoginController {

	@Autowired
	StudentLoginService studentLoginService;
	
	@GetMapping("/login/go")
	public String go() {
		return "student/login/studentLogin";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("account")String account,@RequestParam("password")String password,HttpSession session,Model model) {
		
		StudentLoginLog studentLoginLog=studentLoginService.checkLogin(account, password);
		
		if("0".equals(studentLoginLog.getStatus())){ //0:正常 1：異常
			session.setAttribute("user_information", studentLoginLog.getStudent());
			model.addAttribute("system_information", studentLoginLog.getMessage());
			
			return "student/user/user";
		}
		else {
			model.addAttribute("system_information", studentLoginLog.getMessage());
			return "student/login/studentLogin";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		StudentLoginLog studentLoginLog=new StudentLoginLog();
		studentLoginLog.setMessage("已登出");
		session.setAttribute("user_information", "logout");
		return "student/login/studentLogin";
		
	}
	
	
	
	
	
	
}
