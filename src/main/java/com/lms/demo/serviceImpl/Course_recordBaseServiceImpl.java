package com.lms.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.model.Course;
import com.lms.demo.model.Course_record;
import com.lms.demo.model.Student;
import com.lms.demo.model.log.Course_recordLog;
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.repository.Course_recordRepository;
import com.lms.demo.service.course_record.Course_recordBaseService;

@Service
public class Course_recordBaseServiceImpl implements Course_recordBaseService {
	
	@Autowired
	Course_recordRepository course_recordRepository;
	
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Course_recordLog add(Student student, Course course) {
		Course_record new_course_record=new Course_record();
		Course_recordLog course_recordLog=new Course_recordLog();
		
		if(course.getMaxnumber()>course.getNow_student_number()) { //當現有選課人數小於課程上限人數才可以選課
			
			new_course_record.setStatus("0");
			course_recordRepository.save(new_course_record);
			
			//回傳選課狀態log
			course_recordLog.setStatus("0");
			course_recordLog.setMessage("選課成功");
			course_recordLog.setCourse_record(new_course_record);
			return course_recordLog;
		}
		course_recordLog.setStatus("1");
		course_recordLog.setMessage("修課人數達到上限,選課失敗");
		return course_recordLog;
	}

	@Override
	public List<Integer> getStudentChooseCourse_id(Student student) {
		return null;
		
	}

}
