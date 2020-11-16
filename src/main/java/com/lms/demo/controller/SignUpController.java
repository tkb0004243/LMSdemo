package com.lms.demo.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import com.lms.demo.util.VertifyCodeMake;

@Controller
public class SignUpController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentSignUpService studentSignUpService;
	
	@Autowired
	JavaMailSender mailSender;
	
	@GetMapping("/login")
	public String goSignUp() { //get請求跳轉網頁
		return "login";
		
	}
	
	@PostMapping("/signup")
	public  String createStudent(@ModelAttribute Student newstudent,Model model){
		Timestamp ts = new Timestamp(System.currentTimeMillis()); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String dateStringParse = sdf.format(date);
		ts=Timestamp.valueOf(dateStringParse);
		newstudent.setVertify_email_time(ts.toString());
		newstudent.setAuthorities("student");
		newstudent.setStatus("1");
		newstudent.setVertifycode(VertifyCodeMake.returnVertifyCode());
		LoginLog loginLog=studentSignUpService.vertifySignUp(newstudent);
		if(loginLog.getStatus()==0) {
			studentRepository.save(newstudent);
			return "login";
		}
		model.addAttribute("loginLog", loginLog);
		System.out.println(loginLog.getMessage());
		return "login";
	}
	
	@GetMapping("/mail")
	public String testmail() {
		SimpleMailMessage message = new SimpleMailMessage();
	    message.setFrom("byone@tkbnews.com.tw");
	    message.setTo("digitalken1127@gmail.com");
	    message.setSubject("TEST");
	    message.setText("test");
	    mailSender.send(message);
		return "login";
		
	}
}
