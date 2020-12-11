package com.lms.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lms.demo.repository.Course_recordRepository;

@SpringBootTest
public class TestCourse_recordDelete {

	@Autowired
	Course_recordRepository course_recordRepository;
	
	@Test
	void delete() {
		course_recordRepository.deleteByCourse_id(7);
	}
}
