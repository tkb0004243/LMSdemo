package com.lms.demo.controller.front.student;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.lms.demo.model.log.LoginLog;
import com.lms.demo.model.log.LogoutLog;
import com.lms.demo.service.logout.LogoutBasicService;
import com.lms.demo.service.student.StudentLoginService;

@Controller
@RequestMapping(value="/student")
public class LoginController {

	@Autowired
	StudentLoginService studentLoginService;
	
	@Autowired
	LogoutBasicService logoutBasicService; 
	
	@GetMapping(value={"/login","/login/","/login/ "})
	public String goLogin() {
		return "student/login/studentLogin";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("account")String account,@RequestParam("password")String password,HttpSession session,Model model) {
		
		LoginLog studentLoginLog=studentLoginService.checkLogin(account, password);
		
		if("0".equals(studentLoginLog.getStatus())){ //0:正常 1：異常
			session.setAttribute("user_information", studentLoginLog);
			
			model.addAttribute("system_message", studentLoginLog);
			model.addAttribute("path", "/student/user");
			return "student/path";
		}
		else {
			model.addAttribute("system_message", studentLoginLog);
			model.addAttribute("path", "student/login/studentLogin");
			return "/student/path";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session,Model model) {
		LogoutLog logoutLog=logoutBasicService.logout(session);
		if(logoutLog!=null) {
			if("teacher".equals(logoutLog.getAuthority())&&"0".equals(logoutLog.getStatus())){
				model.addAttribute("system_message", logoutLog);
				model.addAttribute("path", "/backstage/login");
				return "/admin/path";
			}
			model.addAttribute("system_message", logoutLog);
			model.addAttribute("path", "student/login/go");
			
			return "/student/path";
			
		}
		else {
			return "/student/login/go";
		}
		}
		
	
	
	
	
}
