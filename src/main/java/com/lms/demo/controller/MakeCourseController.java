package com.lms.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lms.demo.model.Course;
import com.lms.demo.repository.CourseRepository;

@Controller
public class MakeCourseController {

	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/createcourse")
	public String createCourse(@ModelAttribute Course newcourse) {
		courseRepository.save(newcourse);
		return "showcourse";
	}
}
