package com.lms.demo.controller.front.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import com.lms.demo.model.log.BaseLog;
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
		List<Course> coursecanchoose=courseRepository.findCourseCanChoose();
		
		LoginLog studentLoginLog=(LoginLog) session.getAttribute("user_information");
		List<Course> choose_course=course_recordBaseService.getStudentChooseCourse(studentLoginLog.getStudent());
		
		if(choose_course!=null&&choose_course.size()>0) {
			coursecanchoose=coursecanchoose.stream().filter(result->!choose_course.contains(result)).collect(Collectors.toList()); //過濾掉已經在choose_courses的課程
		
		model.addAttribute("choose_result",choose_course);
		
		}
		model.addAttribute("search_result",coursecanchoose);
		return "student/course/showCourse";
		
		
		
		
	}
}
