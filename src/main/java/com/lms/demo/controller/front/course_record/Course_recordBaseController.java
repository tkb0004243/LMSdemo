package com.lms.demo.controller.front.course_record;

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
import com.lms.demo.model.log.CourserecordLog;
import com.lms.demo.model.log.LoginLog;
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.repository.Course_recordRepository;
import com.lms.demo.repository.StudentRepository;
import com.lms.demo.service.course.CourseBasicService;
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
	
	@Autowired
	CourseBasicService courseBasicService;
	
	
	@PostMapping("/courserecord/add")
	public String add(Model model,HttpSession session,@RequestParam(name="course_id")Integer course_id) {
		Optional<Course> courseOptional=courseRepository.findById(course_id);
		Course course=courseOptional.orElse(new Course());
		Course_recordLog course_recordLog=new Course_recordLog();
		Course_record new_Course_record=new Course_record();
		Student student=new Student();
		LoginLog loginLog=(LoginLog) session.getAttribute("user_information");
		if(loginLog.getStudent()!=null) {
			student=loginLog.getStudent();
		}
	
		
		course_recordLog=course_recordBaseService.checkAddCourseRecord(student, course);
		
		
		if(course_recordLog.getStatus()!=null&&"0".equals(course_recordLog.getStatus())) {
			new_Course_record.setStatus("0");
			new_Course_record.setCourse(course);
			new_Course_record.setStudent(student);
			new_Course_record.setCreate_by(student.getName());
			course_recordLog.setMessage("選課成功");
			Course new_course=course_recordLog.getCourse();
			new_course.setNow_student_number(new_course.getNow_student_number()+1); //現有選課人數+1
			course_recordRepository.save(new_Course_record);
			courseRepository.save(new_course);
		}
	
		
		
		model.addAttribute("system_message", course_recordLog);
		model.addAttribute("path", "/student/course/search");
		
		return "student/path";
		
	}
	
	@PostMapping("/courserecord/delete")
	public String delete(Model model,HttpSession session,@RequestParam(name="course_id")Integer course_id) {
		Course_recordLog course_recordLog=new Course_recordLog();
		LoginLog loginLog=(LoginLog) session.getAttribute("user_information");
		Course course=courseRepository.findById(course_id).get();
		Student student=loginLog.getStudent();
		course_recordLog=course_recordBaseService.delete(student, course);
		
		if("0".equals(course_recordLog.getStatus())) {
			Course new_course=course_recordLog.getCourse();
			new_course.setNow_student_number(new_course.getNow_student_number()-1);
			courseRepository.save(new_course); //課程現有人數-1
			course_recordLog.setMessage("課程刪除成功");
			
		}
		else {
			course_recordLog.setMessage("課程刪除失敗");
		}
		
		model.addAttribute("system_message", course_recordLog);
		model.addAttribute("path", "/student/course/search");
		
		
		
		
		
		return "student/path";
	
	}	
}
