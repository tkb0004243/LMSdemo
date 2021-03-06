package com.lms.demo.controller.course_record;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.demo.model.Course;
import com.lms.demo.model.Course_record;
import com.lms.demo.model.Student;
import com.lms.demo.model.log.Course_recordLog;
import com.lms.demo.model.log.StudentLoginLog;
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.repository.Course_recordRepository;
import com.lms.demo.repository.StudentRepository;
import com.lms.demo.service.course_record.Course_recordBaseService;
import com.sun.xml.bind.v2.runtime.output.StAXExStreamWriterOutput;

@Controller
@RequestMapping(value="/student",method = {RequestMethod.GET,RequestMethod.POST})
public class Course_recordBaseController {

	@Autowired
	Course_recordRepository course_recordRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	Course_recordBaseService course_recordBaseService;
	
	
	@PostMapping("/courserecord/add")
	public String add(Model model,HttpSession session,@RequestParam(name="course_id")Integer course_id) {
		Optional<Course> course=courseRepository.findById(course_id);
		Student student=(Student) session.getAttribute("user_information");
		List<Course> search_result=courseRepository.findAll();
		if(course.isPresent()) {
			Course_recordLog course_recordLog=course_recordBaseService.add(student, course.get());
			System.out.println("course.get():"+course.get());
			model.addAttribute("system_information", course_recordLog.getMessage());
		}
		List<Integer>choose_result=course_recordBaseService.getStudentChooseCourse_id(student);
		model.addAttribute("system_information", "查無此課程");
		model.addAttribute("search_result", search_result);
		model.addAttribute("choose_result",choose_result);
		
		return "student/course/showcourse";
	}
	
	@PostMapping("/courserecord/delete")
	public String delete(Model model,HttpSession session,@RequestParam(name="course_id")Integer course_id) {
		String system_message_str = null;
		StudentLoginLog studentLoginLog =(StudentLoginLog) session.getAttribute("user_information");
		List<Course_record> result=course_recordRepository.findByCourseIDAndStudentID(course_id, studentLoginLog.getStudent().getStudent_id());
		if(result!=null) { 
			Course_record newone=result.get(0);
			newone.setStatus("1");
			course_recordRepository.save(newone);
			system_message_str+="刪除成功";
		}
		else {
			system_message_str+="刪除失敗";
		}
		
		model.addAttribute("system_message", system_message_str);
		return "student/course/showCourse";
		
		
	}
	
}
