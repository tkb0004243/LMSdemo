package com.lms.demo.model.log;

import com.lms.demo.model.Student;

public class StudentLoginLog extends BaseLog {
	
	private final String authority="student";
	
	private Student student;


	public StudentLoginLog() {
		
	}

	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	public String getAuthority() {
		return authority;
	}


	
}
