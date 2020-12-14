package com.lms.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lms.demo.model.Course;
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.repository.Course_recordRepository;

@SpringBootTest(classes = DemoApplication.class)
public class TestCourse_recordDelete {

	@Autowired
	Course_recordRepository course_recordRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	void delete() {
		course_recordRepository.deleteByCourse_id(7);
	}
	
	@Test
	void getByName() {
	List<Course> rs= courseRepository.findByCreate_by("ken");
	System.out.println(rs.size());

	}
	}
