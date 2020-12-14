package com.lms.demo.controller.front.teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lms.demo.model.Course;
import com.lms.demo.model.Course_record;
import com.lms.demo.model.Student;
import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.model.log.LoginLog;
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.repository.Course_recordRepository;
import com.lms.demo.repository.TeacherRepository;

@Controller
@RequestMapping("/student/teacher")
public class TeacherBaseController {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	Course_recordRepository course_recordRepository;
	
	
	
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
	@ResponseBody
	public Map<String, Object> search(@RequestParam(value="teacher_name") String teacher_name,Model model,HttpSession session) {
		LoginLog loginLog=(LoginLog) session.getAttribute("user_information");
		Student student=new Student();
		if(loginLog!=null) {
			student=loginLog.getStudent();
		}
		Map<String, Object> results=new HashMap<String, Object>();
		
		List<Course> courses=courseRepository.findByCreate_by(teacher_name);
		
		
		List<Course_record>you_choosecourse_records=course_recordRepository.findByStudent_id(student.getStudent_id());
		
		/*
		 * List<Course> already_choose=you_choosecourse_records.stream().
		 * filter(records->"0".equals(records.getStatus())&&teacher_name
		 * .equals(records.getCourse().getCreate_by()))
		 * .map(records->records.getCourse()).collect(Collectors.toList());
		 * 
		 * List<Course>
		 * not_choose=courses.stream().filter(course->!already_choose.contains(course)).
		 * collect(Collectors.toList());
		 */
		
	
		results.put("not_choose", you_choosecourse_records); 
		results.put("already_choose",  courses);	
		
		
		return results;
	
	}
	

}