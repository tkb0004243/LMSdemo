package com.lms.demo.controller.admin.course;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.mail.search.IntegerComparisonTerm;
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
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.service.course.CourseBasicService;
import com.lms.demo.service.mail.VertifyMailService;



@Controller
@RequestMapping(value="/backstage/course")
public class BackstageCourseController {
	
	@Autowired 
	CourseBasicService courseBasicService;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	VertifyMailService vertifyMailService;
	
	
	
	@GetMapping(value= "/add")
	public String goAddCourse() {
		return "/admin/course/addCourse";
	}
	
	
	@PostMapping(value="/add")
	public String addCourse(@ModelAttribute Course new_course,Model model,HttpSession session) {
		LoginLog loginLog=(LoginLog) session.getAttribute("user_information");
		if(loginLog.getTeacher()!=null) {
			Teacher teacher=loginLog.getTeacher();
			CourseLog courseLog=courseBasicService.checkAddCourse(new_course);
			courseBasicService.addCourse(courseLog, teacher);
			model.addAttribute("system_message", courseLog);
			model.addAttribute("path", "/backstage/course/search");
			
		}
		else {
			BaseLog baseLog=new BaseLog();
			baseLog.setStatus("1");
			baseLog.setMessage("請先登入為教師");
			model.addAttribute("system_message", baseLog);
			model.addAttribute("path", "/backstage/login");
			
		}
		
		
		return "/admin/path";
		
		
	}
	
	@GetMapping("/search")
	public String search(Model model,HttpSession session) { 
		List<Course> allCourses=courseBasicService.searchAllCourse();

		model.addAttribute("search_result", allCourses);
		
		return "/admin/course/showCourse";
		
	}
	
	@PostMapping("/delete")
	public String delete(Model model,HttpSession session,HttpServletRequest request) throws ParseException {
		CourseLog courseLog=new CourseLog();
		String course_id=request.getParameter("course_id");
		Integer int_course_id=Integer.parseInt(course_id);
		Optional<Course> delete_course=courseRepository.findById(int_course_id);
		if(delete_course.isPresent()) {
			courseLog=courseBasicService.checkDeleteCourse(delete_course.get());
			if("0".equals(String.valueOf(courseLog.getStatus()))) {
				courseLog=courseBasicService.sendLetterToDeleteCourseStudent(delete_course.get());
				if("0".equals(String.valueOf(courseLog.getStatus()))) {
					courseLog=courseBasicService.deleteCourse(delete_course.get());
				}
			}	
		}
		else{
			courseLog.setStatus("1");
			courseLog.setMessage("查無此課程");
		}
	
		model.addAttribute("system_message", courseLog);
		model.addAttribute("path", "/backstage/course/search");
		return "/admin/path";
	}
	
	@PostMapping("/modify")
	public String modify(@RequestParam(value="course_id") String course_id_string,Model model) {
		CourseLog courseLog=new CourseLog();
		Integer course_id=Integer.valueOf(course_id_string);
		
		if(course_id!=null) {
			Optional<Course> un_modify_courseOptional=courseRepository.findById(course_id);
			if(un_modify_courseOptional.isPresent()) {
				Course un_modify_course=un_modify_courseOptional.get();
				model.addAttribute("modify_course", un_modify_course);
				return "admin/course/modifyCourse";
			}
		}
		courseLog.setStatus("1");
		courseLog.setMessage("查無此課程");
		model.addAttribute("system_message", courseLog);
		model.addAttribute("path", "/baskstage/course/search");
		
		
		return "admin/path";
		
	}
	
	@PostMapping("/modify/save")
	public String modify_save(Course modify_course,Model model,HttpSession session) {
		CourseLog courseLog=new CourseLog();
		LoginLog teacherLog=(LoginLog)session.getAttribute("user_information");
		Teacher teacher=teacherLog.getTeacher();
		if(modify_course!=null) {
			modify_course.setUpdate_by(teacher.getName());
			courseRepository.save(modify_course);
			courseLog.setStatus("0");
			courseLog.setMessage("課程修改完成");
		}
		else {
			courseLog.setStatus("1");
			courseLog.setMessage("課程修改失敗");
		}
		model.addAttribute("system_message", courseLog);
		model.addAttribute("path", "/backstage/course/search");
		return "admin/path";
		
		
	}
	

}
