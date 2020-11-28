package com.lms.demo.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lms.demo.model.BaseLog;
import com.lms.demo.model.Student;
import com.lms.demo.model.StudentSignUpLog;
import com.lms.demo.model.Teacher;
import com.lms.demo.repository.StudentRepository;
import com.lms.demo.service.mail.VertifyMailService;

@Service
public class VertifyMailServiceImpl implements VertifyMailService {

	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	StudentRepository studentRepository;

	public BaseLog sendVertifyMail(Student newstudent) throws MessagingException {
		BaseLog baseLog = new BaseLog();
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom("digitalken1127@gmail.com");
			helper.setTo(newstudent.getEmail());
			helper.setSubject("LMS會員驗證信");
			helper.setText(
					"<!DOCTYPE html>"
					 +"<html>" 
					 +"<body>" 
					 +"<h1>會員驗證信</h1>"
					 +"<p>請點選驗證按鈕</p>"
					 +"<form action='http://localhost:8080/student/mail/get' method='post'>"
					 +"<input type='hidden' name='student_email' value="+newstudent.getEmail()+">"
					 +"<input type='hidden' name='vertifycode' value="+newstudent.getVertify_code()+">"
					 +"<button type='submit'>提交驗證</button>" 
					 + "</form>"
					 + "</body>"
					 + "</html>",
					true);
			
			baseLog.setStatus("0");
			baseLog.setMessage("寄信成功");
			mailSender.send(mimeMessage);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			baseLog.setStatus("1");
			baseLog.setMessage("寄送失敗");
			
		}
		return baseLog;
		

	}
	
	
	public BaseLog sendVertifyMailToTeacher(Teacher newteacher) throws MessagingException {
		
		BaseLog baseLog = new BaseLog();
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("digitalken1127@gmail.com");
		helper.setTo(newteacher.getEmail());
		helper.setSubject("LMS會員驗證信");
		helper.setText(
				"<!DOCTYPE html>"
				 +"<html>" 
				 +"<body>" 
				 +"<h1>會員驗證信</h1>"
				 +"<p>請點選驗證按鈕</p>"
				 +"<form action='http://172.16.131.55:8080/getmail' method='post'>"
				 +"<input type='hidden' name='teacher_email' value="+newteacher.getEmail()+">"
				 +"<input type='hidden' name='vertifycode' value="+newteacher.getVertify_code()+">"
				 +"<button type='submit'>提交驗證</button>" 
				 + "</form>"
				 + "</body>"
				 + "</html>",
				true);
		mailSender.send(mimeMessage);
		return baseLog;
	}


	@Override
	public StudentSignUpLog checkReturnVertifyMail(String student_email, String vertifycode) throws ParseException {
		StudentSignUpLog studentSignUpLog=new StudentSignUpLog();
		List<Student> result=studentRepository.findByEmail(student_email);
		if(result!=null) {
			Student result_stu=result.get(0);
			String trans_str=result_stu.getVertify_email_time();
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date ver_date=sdf.parse(trans_str);
			Date today=new Date();
			long from=today.getTime();
			long to=ver_date.getTime();
			long gap=from-to;
			if(result_stu.getVertify_code().equals(vertifycode)&&gap<(1000*60*60)) { //0:正常 1:異常
				result_stu.setStatus("0");
			studentRepository.save(result_stu);
			studentSignUpLog.setStatus("0");
			studentSignUpLog.setMessage("驗證信接收成功");
			studentSignUpLog.setNew_student(result_stu);
			}
			else {
				studentSignUpLog.setStatus("1");
				studentSignUpLog.setMessage("驗證時間超時");
			}
		return studentSignUpLog;
	}
		studentSignUpLog.setStatus("1");
		studentSignUpLog.setMessage("無此帳號");
		return studentSignUpLog;

	}	

	

}
