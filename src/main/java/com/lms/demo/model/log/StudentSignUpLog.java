package com.lms.demo.model.log;

import com.lms.demo.model.Student;

public class StudentSignUpLog extends BaseLog {
	
	private Student new_student;

	public StudentSignUpLog() {
		
	}

	public Student getNew_student() {
		return new_student;
	}

	public void setNew_student(Student new_student) {
		this.new_student = new_student;
	}
}
