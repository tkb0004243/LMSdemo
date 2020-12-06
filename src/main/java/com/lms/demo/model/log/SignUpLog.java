package com.lms.demo.model.log;

import com.lms.demo.model.Student;
import com.lms.demo.model.Teacher;

public class SignUpLog extends BaseLog{

	
	private Student student;
	
	private Teacher teacher;
	
	private String authority;

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

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
	
}
