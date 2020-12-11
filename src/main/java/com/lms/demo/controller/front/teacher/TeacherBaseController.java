package com.lms.demo.controller.front.teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.demo.model.Course;
import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.repository.TeacherRepository;

@Controller
@RequestMapping("/student/teacher")
public class TeacherBaseController {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	
	
	@GetMapping("/search")
	public String searchAll(Model model) {
		BaseLog baseLog=new BaseLog();
		List<Teacher> all_teacherList=teacherRepository.findAll();
		if(all_teacherList!=null&&all_teacherList.size()>0) {
			model.addAttribute("search_result", all_teacherList);
			return "/student/teacher/showTeacher";
		}
		baseLog.setStatus("1");
		baseLog.setMessage("查無教師");
		model.addAttribute("system_message", baseLog);
		model.addAttribute("path", "/student/user");
		return "student/path";
		
	}
	
	@PostMapping("/search")
	public String search(@RequestParam(value="teacher_id") String teacher_id_string,Model model) {
		BaseLog baseLog=new BaseLog();
		Map<String, Object> course_search=new HashMap<String, Object>();
		
		Integer teacher_id=Integer.valueOf(teacher_id_string);
		Teacher teacher =new Teacher();
		
		if(teacher_id!=null) {
			Optional<Teacher> teacherOptional=teacherRepository.findById(teacher_id);
			if(teacherOptional.isPresent()) {
				 teacher=teacherOptional.get();
				 course_search.put("teacher_name", teacher.getName());
				 List<Course> courses=courseRepository.findByCreate_by(teacher.getName());
				if(courses!=null) {
					course_search.put("courses", courses);
				}
				else {
					course_search.put("courses", null);
				}
				
				model.addAttribute("course_search", course_search);
				return "/student/teacher/showTeacher";
			}
		}
		baseLog.setStatus("1");
		baseLog.setMessage("查無資料");
		model.addAttribute("system_message", baseLog);
		model.addAttribute("path", "/student/teacher/search");
		return "student/path";
		
		
	}

}
