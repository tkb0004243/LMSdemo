package com.lms.demo.service.course;

import com.lms.demo.model.Course;
import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.model.log.CourseLog;

public interface CourseBasicService {

	public CourseLog checkCourse(Course newcourse);
	
	public BaseLog addCourse(CourseLog courseAddLog,Teacher teacher);
}
