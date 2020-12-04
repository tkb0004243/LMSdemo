package com.lms.demo.model.log;

import com.lms.demo.model.Teacher;

public class TeacherSignUpLog extends BaseLog{

	private Teacher teacher;
	
	public TeacherSignUpLog() {
		
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
