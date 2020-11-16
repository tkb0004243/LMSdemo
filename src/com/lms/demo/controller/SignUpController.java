package com.lms.demo.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lms.demo.model.LoginLog;
import com.lms.demo.model.Student;
import com.lms.demo.repository.StudentRepository;
import com.lms.demo.service.StudentSignUpService;

@Controller
public class SignUpController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentSignUpService studentSignUpService;
	
	@GetMapping("/login")
	public String goSignUp() { //get請求跳轉網頁
		return "login";
		
	}
	
	@PostMapping("/signup")
	public  String createStudent(@ModelAttribute Student newstudent,Model model){
		Timestamp ts = new Timestamp(System.currentTimeMillis());  
		String a="2011-05-09 11:49:45";
		ts=Timestamp.valueOf(a);
		newstudent.setVertify_email_time(ts.toString());
		newstudent.setAuthorities("student");
		newstudent.setStatus("0");
		LoginLog loginLog=studentSignUpService.vertifySignUp(newstudent);
		if(loginLog.getStatus()==0) {
			studentRepository.save(newstudent);
			return "login";
		}
		model.addAttribute("loginLog", loginLog);
		System.out.println(loginLog.getMessage());
		return "login";
	}
}
