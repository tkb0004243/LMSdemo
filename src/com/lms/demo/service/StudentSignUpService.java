package com.lms.demo.service;

import com.lms.demo.model.LoginLog;
import com.lms.demo.model.Student;

public interface StudentSignUpService {

	LoginLog vertifySignUp(Student newstudent);
	
}
