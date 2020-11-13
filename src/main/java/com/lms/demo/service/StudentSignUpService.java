package com.lms.demo.service;


import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.lms.demo.model.Student;


public interface StudentSignUpService {

	boolean vertifySignUp(Student newstudent,Model model);
	
}
