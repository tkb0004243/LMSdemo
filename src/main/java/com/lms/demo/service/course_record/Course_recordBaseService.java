package com.lms.demo.service.course_record;

import java.util.List;
import java.util.Optional;

import com.lms.demo.model.Course;
import com.lms.demo.model.Student;
import com.lms.demo.model.log.Course_recordLog;

public interface Course_recordBaseService {
	
	public Course_recordLog add(Student student,Course course);
	
	public List<Optional<Course>> getStudentChooseCourse(Student student);
	
	public Course_recordLog checkAddCourseRecord(Student student,Course course); 
	//調查是否有學生是否有重複選課
	//課程能否是被選擇的狀態
	//現有選課人數是否額滿
	
	public Course_recordLog delete(Student student,Course course);

	}

																				