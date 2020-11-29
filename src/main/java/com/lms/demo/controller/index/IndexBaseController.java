package com.lms.demo.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/",method= {RequestMethod.GET,RequestMethod.POST})
public class IndexBaseController {

	@RequestMapping(value="/",method= {RequestMethod.GET,RequestMethod.POST})
	public String index() {
	return "student/login/studentLogin";	
	}
}
