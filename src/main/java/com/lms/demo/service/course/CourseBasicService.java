package com.lms.demo.service.course;

import java.text.ParseException;
import java.util.List;

import com.lms.demo.model.Course;
import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.model.log.CourseLog;

public interface CourseBasicService {

	public CourseLog checkAddCourse(Course newcourse);
	
	public BaseLog addCourse(CourseLog courseAddLog,Teacher teacher);
	
	public CourseLog deleteCourse(Course delete_course);
	
	public CourseLog checkDeleteCourse(Course delete_course)  throws ParseException;
	
	public CourseLog sendLetterToDeleteCourseStudent(Course delete_course);
	
	public List<Course> searchAllCourse();
}
