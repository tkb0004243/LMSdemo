package com.lms.demo.controller.admin.course;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lms.demo.model.Course;
import com.lms.demo.service.course.CourseBasicService;


@Controller
@RequestMapping(value="/backstage/course")
public class BackstageCourseController {
	
	@Autowired 
	CourseBasicService courseBasicService;
	
	@GetMapping(value="/add")
	public String goAdd() {
		return "/admin/course/createCourse";
	}
	
	@PostMapping(value="/add")
	public String addCourse(@ModelAttribute Course new_course,Model model,HttpSession session) {
		
		courseBasicService.checkCourse(new_course);
		
		
		model.addAttribute("path", "/admin/course/createCourse");
		
		return "/admin/path";
		
		
	}

}
