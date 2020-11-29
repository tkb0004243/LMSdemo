package com.lms.demo.service.student;


import com.lms.demo.model.Student;
import com.lms.demo.model.log.StudentSignUpLog;

public interface StudentSignUpService {
	
	public StudentSignUpLog add(StudentSignUpLog studentSignUpLog);

	public StudentSignUpLog vertifySignUp(Student newstudent);
	
}
