package com.lms.demo.model.log;

import com.lms.demo.model.Course;

public class CourseAddLog extends BaseLog{

	
	private Course course;
	
	public CourseAddLog() {
		
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
