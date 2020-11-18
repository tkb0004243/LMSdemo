package com.lms.demo.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lms.demo.model.LoginLog;
import com.lms.demo.model.Student;
import com.lms.demo.repository.StudentRepository;
import com.lms.demo.service.StudentSignUpService;
import com.lms.demo.service.VertifyMailService;
import com.lms.demo.util.VertifyCodeMake;

@Controller
public class SignUpController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentSignUpService studentSignUpService;
	
	@Autowired
	VertifyMailService vertifyMailService;
	
	
	
	@PostMapping("/signup")
	public  String createStudent(@ModelAttribute Student newstudent,Model model) throws MessagingException{
		Timestamp ts = new Timestamp(System.currentTimeMillis()); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String dateStringParse = sdf.format(date);
		ts=Timestamp.valueOf(dateStringParse);
		newstudent.setVertify_email_time(ts.toString()); //設置驗證時間
		newstudent.setAuthorities("student"); //設置權限
		newstudent.setStatus("1"); //設置狀態 0正常 1未驗證
		newstudent.setVertifycode(VertifyCodeMake.returnVertifyCode()); //設置驗證碼
		LoginLog loginLog=studentSignUpService.vertifySignUp(newstudent);
		
		if(loginLog.getStatus()==0) {
			studentRepository.save(newstudent);
			vertifyMailService.sendVertifyMail(newstudent);
			return "login";
		}
		return "login";
	}
	
	@GetMapping("/mail")
	public String mail() throws MessagingException {
		
		return "login";
		
	}
	
	@PostMapping("/getmail") //接收驗證信回傳
	public String getMail(HttpServletRequest request) throws MessagingException {
		String student_email=request.getParameter("student_email");
		String vertifycode=request.getParameter("vertifycode");
		
		
		return null;
		
		
	}
}
