package com.lms.demo.model;

public class TeacherLoginLog extends BaseLog{
	
	private Teacher teacher;

	public TeacherLoginLog() {
		
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
