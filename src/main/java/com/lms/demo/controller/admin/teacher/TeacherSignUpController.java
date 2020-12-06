package com.lms.demo.controller.admin.teacher;

import java.text.ParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.SignUpLog;
import com.lms.demo.repository.TeacherRepository;
import com.lms.demo.service.teacher.TeacherService;

@Controller
public class TeacherSignUpController {
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@PostMapping("/backstage/signup")
	public String signup(@ModelAttribute Teacher newteacher)
	{	
		teacherService.signup(newteacher);
		
		return "/admin/login/TeacherLogin";
	}
	
	@PostMapping("/backstage/getmail")
	public String getmail(HttpServletRequest request,Model model) throws ParseException {
		String teacher_email=request.getParameter("teacher_email");
		List<Teacher> result=teacherRepository.findByEmail(teacher_email);
		SignUpLog teacherSignUpLog=teacherService.getmail(result, request);
		model.addAttribute("system_message", teacherSignUpLog);
		return "/admin/login/TeacherLogin";	
		
	}
	
	}
	

