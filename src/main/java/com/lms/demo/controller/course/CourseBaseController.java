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
@RequestMapping(value="/student/course",method= {RequestMethod.GET,RequestMethod.POST})
public class CourseBaseController {

	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping("/show")
	public String goShow() { 
		return "student/course/showCourse";
	}
	
	@GetMapping("course/create")
	public String goMakeCourse() { 
		return "student/course/createCourse";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute Course newcourse) {
		courseRepository.save(newcourse);
		return "student/course/showCourse";
	}
	
	@GetMapping("/search")
	public String search(Model model) {
		List<Course> result=courseRepository.findAll();
		model.addAttribute("search_result", result);
		return "student/course/showCourse";
		
	}
}
