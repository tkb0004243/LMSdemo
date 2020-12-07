package com.lms.demo.controller.front.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/student/user",method= {RequestMethod.GET,RequestMethod.POST})
public class UserBasicController {

	@GetMapping(value={"/"," ",""})
	public String goUser() { 
		return "student/user/user";
	}
}
