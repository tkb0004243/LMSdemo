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
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.demo.model.Course;
import com.lms.demo.model.Course_record;
import com.lms.demo.model.Student;
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.repository.Course_recordRepository;
import com.lms.demo.repository.StudentRepository;
import com.sun.xml.bind.v2.runtime.output.StAXExStreamWriterOutput;

@Controller
public class Course_recordBaseController {

	@Autowired
	Course_recordRepository course_recordRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	
	@PostMapping("/courserecord/add")
	public String add(Model model,HttpSession session,@RequestParam(name="course_id")Integer course_id) {
		Course_record newcourserecord=new Course_record();
		Student userStudent=new Student(); 
		Optional<Course> course=courseRepository.findById(course_id);
		 if(course.isPresent()) { 
		newcourserecord.setCourse(course.get());
		newcourserecord.setStudent(userStudent);
		course_recordRepository.save(newcourserecord);
		}
		return "showcourse";
	}
	
	@PostMapping("/courserecord/delete")
	public String delete(Model model,HttpSession session,@RequestParam(name="course_id")Integer course_id) {
		List<Course_record> result=course_recordRepository.findByCourseIDAndStudentID(course_id, 9);
		if(result!=null) { 
		course_recordRepository.delete(result.get(0));
		System.out.println(result.get(0));
		System.out.println("刪除成功");
		}
		else {
			System.out.println("刪除失敗");
		}
		return "showcourse";
		
		
	}
	
}
