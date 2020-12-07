package com.lms.demo.controller.admin.course;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.demo.model.Course;
import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.model.log.CourseLog;
import com.lms.demo.model.log.LoginLog;
import com.lms.demo.service.course.CourseBasicService;


@Controller
@RequestMapping(value="/backstage/course")
public class BackstageCourseController {
	
	@Autowired 
	CourseBasicService courseBasicService;
	
	
	
	
	
	@GetMapping(value= "/add")
	public String goAddCourse() {
		return "/admin/course/addCourse";
	}
	
	
	@PostMapping(value="/add")
	public String addCourse(@ModelAttribute Course new_course,Model model,HttpSession session) {
		LoginLog loginLog=(LoginLog) session.getAttribute("user_information");
		if(loginLog.getTeacher()!=null) {
			Teacher teacher=loginLog.getTeacher();
			CourseLog courseLog=courseBasicService.checkCourse(new_course);
			courseBasicService.addCourse(courseLog, teacher);
			model.addAttribute("system_message", courseLog);
			model.addAttribute("path", "/backstage/course/search");
			return "/admin/path";
		}
		
		BaseLog baseLog=new BaseLog();
		baseLog.setStatus("1");
		baseLog.setMessage("請先登入為教師");
		model.addAttribute("system_message", baseLog);
		model.addAttribute("path", "/backstage/login");
		return "/admin/path";
		
		
	}
	
	@GetMapping("/search")
	public String search(Model model,HttpSession session) {
		
		List<Course> allCourses=courseBasicService.searchAllCourse();
		model.addAttribute("search_result", allCourses);
		
		return "/admin/course/showCourse";
		
	}
	
	@PostMapping("/delete")
	public String delete(Model model,HttpSession session,HttpServletRequest request) {
		String course_id=request.getParameter("course_id");
		
		
		Integer int_course_id=Integer.parseInt(course_id);
		
		BaseLog resultBaseLog=courseBasicService.deleteCourse(int_course_id);
		
		model.addAttribute("system_message", resultBaseLog);
		model.addAttribute("path", "/backstage/course/search");
		
			
		
		return "/admin/path";
		
		
		
	}
	

}
