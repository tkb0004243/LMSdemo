package com.lms.demo.controller.front.student;


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
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.demo.model.Student;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.model.log.SignUpLog;
import com.lms.demo.repository.StudentRepository;
import com.lms.demo.service.mail.VertifyMailService;
import com.lms.demo.service.student.StudentSignUpService;
import com.lms.demo.util.VertifyCodeMake;

@Controller
@RequestMapping(value="/student")
public class SignUpController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentSignUpService studentSignUpService;
	
	@Autowired
	VertifyMailService vertifyMailService;
	
	
	
	@PostMapping("/signup")
	public  String signup(@ModelAttribute Student newstudent,Model model) throws MessagingException{
		BaseLog baseLog=new BaseLog();
		SignUpLog studentSignUpLog=studentSignUpService.vertifySignUp(newstudent);
		if("0".equals(studentSignUpLog.getStatus())) {
			studentSignUpService.add(studentSignUpLog);
			baseLog=vertifyMailService.sendVertifyMailToStudent(studentSignUpLog.getStudent());
		}
		else {
			baseLog.setStatus("1");
			baseLog.setMessage("註冊失敗");
		}
		
		model.addAttribute("system_message", baseLog);
		model.addAttribute("path", "/student/login");
		
		return "student/path";
		
	}
	
	@GetMapping("/mail/resend")
	public String goResend() {
		return "student/mail/sendMail";
		
	}
	
	@PostMapping("mail/get") //接收驗證信回傳
	public String getMail(HttpServletRequest request,Model model) throws ParseException {
		String student_email=request.getParameter("student_email"); 
		String vertifycode=request.getParameter("vertifycode");
		
		SignUpLog studentSignUpLog=vertifyMailService.checkReturnVertifyMail(student_email,vertifycode);
		
		if("0".equals(studentSignUpLog.getStatus())) {
			model.addAttribute("system_information", studentSignUpLog.getMessage());
			return "student/login/studentLogin";
		}
		model.addAttribute("system_information", studentSignUpLog.getMessage());
		return "student/mail/reSend";
			
		}
		
		
	@PostMapping("mail/resend")	
	public String resend(@RequestParam(value="user_account") String user_account,Model model) throws MessagingException {
		BaseLog baseLog=new BaseLog();
		Student new_student=new Student();
		List<Student> newst=studentRepository.findByEmail(user_account);
		if(newst!=null&&newst.size()>0) { //有找到學生在資料庫但未驗證資料
			new_student=newst.get(0);
			baseLog=vertifyMailService.sendVertifyMailToStudent(new_student);
		}
		else {
			baseLog.setStatus("1");
			baseLog.setMessage("查無此用戶,請重新註冊");
		}
		model.addAttribute("system_message", baseLog);
		model.addAttribute("path","/student/login");
		
		
		
		return "student/path";
		
		
		
	}
	
	
	}

