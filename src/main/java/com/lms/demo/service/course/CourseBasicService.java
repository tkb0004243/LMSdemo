package com.lms.demo.service.course;

import com.lms.demo.model.Course;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.model.log.CourseAddLog;

public interface CourseBasicService {

	public CourseAddLog checkCourse(Course newcourse);
	
	public BaseLog addCourse(CourseAddLog courseAddLog);
}
