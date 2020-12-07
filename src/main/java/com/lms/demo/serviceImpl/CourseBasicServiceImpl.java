package com.lms.demo.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.model.Course;
import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.model.log.CourseLog;
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.service.course.CourseBasicService;

@Service
public class CourseBasicServiceImpl implements CourseBasicService {

	
	@Autowired
	CourseRepository courseRepository;
	
	
	
	
	@Override
	public CourseLog checkCourse(Course newcourse) {
		CourseLog courseAddLog=new CourseLog();
		
		
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
	public CourseLog addCourse(CourseLog courseAddLog,Teacher teacher) {
		if("0".equals(courseAddLog.getStatus())) {
			
			courseAddLog.getCourse().setCreate_by(teacher.getName());
			courseAddLog.getCourse().setNow_student_number(0);
			courseRepository.save(courseAddLog.getCourse());
			return courseAddLog;
		}
		courseAddLog.setMessage("課程寫入資料庫失敗");
		return courseAddLog;
	}

	@Override
	public List<Course> searchAllCourse() {
		List<Course> allCourses=courseRepository.findAll();
		return allCourses;
	}

	@Override
	@Transactional
	public BaseLog deleteCourse(Integer course_id) {
		BaseLog baseLog=new BaseLog();
		try {
			System.out.println("course_id:"+course_id);
			courseRepository.deleteById(course_id);
			baseLog.setStatus("0");
			baseLog.setMessage("課程已經刪除");
		}
		catch (Exception e) {
			baseLog.setStatus("1");
			baseLog.setStatus("發生異常,無法刪除");
		}
		return baseLog;
		
	}

}
