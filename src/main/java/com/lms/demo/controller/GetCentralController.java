package com.lms.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetCentralController {
	
	@GetMapping("/login")
	public String goSignUp() {
		return "login";
	}
	
	@GetMapping("/showcourse")
	public String goShowCourse() { 
		return "showcourse";
	}
	
	@GetMapping("/user")
	public String goUser() { 
		return "user";
	}
	
	@GetMapping("/makecourse")
	public String goMakeCourse() { 
		return "makecourse";
	}
	
	

}
