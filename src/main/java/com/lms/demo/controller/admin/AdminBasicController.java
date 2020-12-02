package com.lms.demo.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin",method= {RequestMethod.GET,RequestMethod.POST})
public class AdminBasicController {
	
	

	@GetMapping("/adminlogin")
	public String goAdminlogin() {
		return "adminlogin";
		
	}
	
	
	
	
	

}
