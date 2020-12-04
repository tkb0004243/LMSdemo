package com.lms.demo.model.log;

import com.lms.demo.model.Teacher;

public class TeacherLoginLog extends BaseLog{
	
	private Teacher teacher;
	
	private final String authority="teacher";

	public TeacherLoginLog() {
		
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

	
}
