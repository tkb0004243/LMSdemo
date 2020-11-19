package com.lms.demo.model;

public class LoginLog extends BaseLog {
	
	
	private Teacher teacher;
	
	private Student student;


	public LoginLog() {
		
	}

	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
