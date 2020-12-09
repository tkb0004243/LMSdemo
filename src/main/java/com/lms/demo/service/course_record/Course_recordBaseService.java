package com.lms.demo.service.course_record;

import java.util.List;

import com.lms.demo.model.Course;
import com.lms.demo.model.Student;
import com.lms.demo.model.log.Course_recordLog;

public interface Course_recordBaseService {
	
	public Course_recordLog add(Student student,Course course);
	
	public List<Integer> getStudentChooseCourse_id(Student student);
	
	public Course_recordLog checkAddCourseRecord(Student student,Course course);
		


}
