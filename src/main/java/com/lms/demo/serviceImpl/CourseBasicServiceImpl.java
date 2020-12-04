package com.lms.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.model.Course;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.model.log.CourseAddLog;
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.service.course.CourseBasicService;

@Service
public class CourseBasicServiceImpl implements CourseBasicService {

	
	@Autowired
	CourseRepository courseRepository;
	
	
	@Override
	public CourseAddLog checkCourse(Course newcourse) {
		CourseAddLog courseAddLog=new CourseAddLog();
		
		
		if(newcourse!=null) {
			courseRepository.save(newcourse);
			courseAddLog.setStatus("0");
			courseAddLog.setMessage("課程創建成功");
			courseAddLog.setCourse(newcourse);
			return courseAddLog;
			
		}
		courseAddLog.setStatus("1");
		courseAddLog.setMessage("課程創建失敗");
		return courseAddLog;
	}

	@Override
	public CourseAddLog addCourse(CourseAddLog courseAddLog) {
		BaseLog baseLog=new BaseLog();
		if("0".equals(courseAddLog.getStatus())) {
			courseRepository.save(courseAddLog.getCourse());
			return courseAddLog;
		}
		return courseAddLog;
	}

}
