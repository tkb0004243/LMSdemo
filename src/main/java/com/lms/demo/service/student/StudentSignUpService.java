package com.lms.demo.service.student;


import com.lms.demo.model.Student;
import com.lms.demo.model.StudentSignUpLog;

public interface StudentSignUpService {

	public StudentSignUpLog vertifySignUp(Student newstudent);
	
}
