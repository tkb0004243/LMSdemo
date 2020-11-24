package com.lms.demo.controller.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lms.demo.model.Course;
import com.lms.demo.repository.CourseRepository;

@Controller
public class CourseBaseController {

	@Autowired
	CourseRepository courseRepository;
	
	@PostMapping("/course/create")
	public String createCourse(@ModelAttribute Course newcourse) {
		courseRepository.save(newcourse);
		return "showcourse";
	}
	
	@GetMapping("/course/search")
	public String searchAll(Model model) {
		List<Course> result=courseRepository.findAll();
		model.addAttribute("search_result", result);
		return "showcourse";
		
	}
}
