package com.lms.demo.model.log;

import com.lms.demo.model.Course_record;

public class CourserecordLog extends BaseLog {

	private Course_record courserecord;
	
	public CourserecordLog() {
		
	}

	public Course_record getCourserecord() {
		return courserecord;
	}

	public void setCourserecord(Course_record courserecord) {
		this.courserecord = courserecord;
	}
	
	
}
