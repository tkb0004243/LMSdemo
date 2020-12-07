package com.lms.demo.service.course;

import java.util.List;

import com.lms.demo.model.Course;
import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.model.log.CourseLog;

public interface CourseBasicService {

	public CourseLog checkCourse(Course newcourse);
	
	public BaseLog addCourse(CourseLog courseAddLog,Teacher teacher);
	
	public BaseLog deleteCourse(Integer course_id);
	
	public List<Course> searchAllCourse();
}
