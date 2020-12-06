package com.lms.demo.model.log;

import com.lms.demo.model.Student;
import com.lms.demo.model.Teacher;

public class LoginLog extends BaseLog {

	private String authority;
	
	private Student student;
	
	private Teacher teacher;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
