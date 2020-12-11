package com.lms.demo.controller.common;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lms.demo.model.log.LogoutLog;
import com.lms.demo.service.logout.LogoutBasicService;

@Controller
@RequestMapping(value="/logout")
public class CommonBasicController {
	
	@Autowired
	LogoutBasicService logoutBasicService;

	
	@RequestMapping(value= {"/",""},method = {RequestMethod.GET,RequestMethod.POST})
	public String logout(HttpSession session,Model model) {
		
		LogoutLog logoutLog=logoutBasicService.logout(session);
		if(logoutLog!=null) {
			if("teacher".equals(logoutLog.getAuthority())&&"0".equals(logoutLog.getStatus())){
				model.addAttribute("system_message", logoutLog);
				model.addAttribute("path", "/backstage/login");
				return "/admin/path";
			}
			model.addAttribute("system_message", logoutLog);
			model.addAttribute("path", "student/login");
			
			return "/student/path";
			
		}
		else {
			return "/student/login";
		}
		}
		
	
}
