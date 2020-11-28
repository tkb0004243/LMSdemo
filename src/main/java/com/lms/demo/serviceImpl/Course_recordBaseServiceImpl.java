package com.lms.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.model.Course;
import com.lms.demo.model.Course_record;
import com.lms.demo.model.Student;
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
	public void add(Student student, Course course) {
		Course_record course_record=new Course_record();
		
		course_record.setStudent(student);
		course_record.setCourse(course);
		course_record.setStatus("0"); //0:正常選課 1：取消選課
		course_recordRepository.save(course_record); //選課紀錄表單新增一項選課紀錄
		Integer now_Student_Number=course_recordRepository.countNow_Student_Number(course.getCourse_id()); //計算目前課程選課的人數
		course.setNow_student_number(now_Student_Number); //課程更新選課人數
		courseRepository.save(course); //把課程存進資料庫
	}

}
