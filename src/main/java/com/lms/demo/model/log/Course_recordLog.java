package com.lms.demo.model.log;

import com.lms.demo.model.Course_record;

public class Course_recordLog extends BaseLog{

	private Course_record course_record;
	
	public Course_recordLog() {
		
	}

	public Course_record getCourse_record() {
		return course_record;
	}

	public void setCourse_record(Course_record course_record) {
		this.course_record = course_record;
	}
}
