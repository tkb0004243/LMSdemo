package com.lms.demo.controller.front.course;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.lms.demo.model.Student;
import com.lms.demo.model.log.LoginLog;
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.service.course_record.Course_recordBaseService;

@Controller
@RequestMapping(value="/student/course",method= {RequestMethod.GET,RequestMethod.POST})
public class CourseBaseController {
	
	@Autowired
	Course_recordBaseService course_recordBaseService;

	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping("/show")
	public String goShow() { 
		return "student/course/showCourse";
	}
	
	
	
	@GetMapping("/search")
	public String search(Model model,HttpSession session) {
		List<Course> search_result=courseRepository.findAll();
		LoginLog studentLoginLog=(LoginLog) session.getAttribute("user_information");
		List<Integer> choose_result=course_recordBaseService.getStudentChooseCourse_id(studentLoginLog.getStudent());
		model.addAttribute("search_result",search_result);
		model.addAttribute("choose_result",choose_result);
		return "student/course/showCourse";
		
	}
}
