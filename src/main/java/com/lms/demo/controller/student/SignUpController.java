package com.lms.demo.controller.student;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lms.demo.model.BaseLog;
import com.lms.demo.model.Student;
import com.lms.demo.model.StudentSignUpLog;
import com.lms.demo.repository.StudentRepository;
import com.lms.demo.service.mail.VertifyMailService;
import com.lms.demo.service.student.StudentSignUpService;
import com.lms.demo.util.VertifyCodeMake;

@Controller
@RequestMapping(value="/student",method= {RequestMethod.GET,RequestMethod.POST})
public class SignUpController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentSignUpService studentSignUpService;
	
	@Autowired
	VertifyMailService vertifyMailService;
	
	
	
	@PostMapping("/signup")
	public  String signup(@ModelAttribute Student newstudent,Model model) throws MessagingException{
		StudentSignUpLog studentSignUpLog=studentSignUpService.vertifySignUp(newstudent);
		if("0".equals(studentSignUpLog.getStatus())) {
			 studentSignUpService.add(studentSignUpLog);
			BaseLog baseLog=vertifyMailService.sendVertifyMail(studentSignUpLog.getNew_student());
			model.addAttribute("system_information", studentSignUpLog.getMessage()+baseLog.getMessage());  //帶系統訊息回去
			return "student/login/studentLogin";
		}
		model.addAttribute("system_information", studentSignUpLog.getMessage()); //帶系統訊息回去
		return "student/login/studentLogin";
	}
	
	@GetMapping("/mail/go")
	public String go() {
		return "student/mail/sendMail";
		
	}
	
	@PostMapping("mail/get") //接收驗證信回傳
	public String getMail(HttpServletRequest request,Model model) throws ParseException {
		String student_email=request.getParameter("student_email"); 
		String vertifycode=request.getParameter("vertifycode");
		
		StudentSignUpLog studentSignUpLog=vertifyMailService.checkReturnVertifyMail(student_email,vertifycode);
		
		if("0".equals(studentSignUpLog.getStatus())) {
			model.addAttribute("system_information", studentSignUpLog.getMessage());
			return "student/login/studentLogin";
		}
		model.addAttribute("system_information", studentSignUpLog.getMessage());
		return "student/mail/reSend";
			
		}
		
		
	@PostMapping("mail/resend")	
	public String resend(HttpServletRequest request,Model model) {
		
		return null;
		
	}
	
	
	}

