package com.lms.demo;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lms.demo.model.Course;
import com.lms.demo.repository.CourseRepository;

@SpringBootTest(classes = DemoApplication.class)
public class TestCourse {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Test
	void Test() {
		Optional<Course> courseOptional=courseRepository.findById(11);
		Course course=courseOptional.orElse(new Course());
		course.setCourse_status("1");
		courseRepository.save(course);
	}

}
