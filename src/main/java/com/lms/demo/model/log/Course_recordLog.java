package com.lms.demo.model.log;

import com.lms.demo.model.Course;
import com.lms.demo.model.Course_record;
import com.lms.demo.model.Student;

public class Course_recordLog extends BaseLog{

	private Course_record course_record;
	
	private Student student;
	
	private Course course;
	
	public Course_recordLog() {
		
	}

	public Course_record getCourse_record() {
		return course_record;
	}

	public void setCourse_record(Course_record course_record) {
		this.course_record = course_record;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
