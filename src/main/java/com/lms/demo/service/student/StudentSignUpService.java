package com.lms.demo.service.student;


import com.lms.demo.model.Student;
import com.lms.demo.model.log.SignUpLog;


public interface StudentSignUpService {
	
	public SignUpLog add(SignUpLog studentSignUpLog);

	public SignUpLog vertifySignUp(Student newstudent);
	
}
