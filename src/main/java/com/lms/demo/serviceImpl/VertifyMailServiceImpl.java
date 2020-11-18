package com.lms.demo.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lms.demo.model.BaseLog;
import com.lms.demo.model.Student;
import com.lms.demo.service.VertifyMailService;

@Service
public class VertifyMailServiceImpl implements VertifyMailService {

	@Autowired
	JavaMailSender mailSender;

	public BaseLog sendVertifyMail(Student newstudent) throws MessagingException {
		BaseLog baseLog = new BaseLog();
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("digitalken1127@gmail.com");
		helper.setTo(newstudent.getStudent_email());
		helper.setSubject("LMS會員驗證信");
		helper.setText(
				"<!DOCTYPE html>"
				 +"<html>" 
				 +"<body>" 
				 +"<h1>會員驗證信</h1>"
				 +"<p>請點選驗證按鈕</p>"
				 +"<form action='getmail' method='post'>"
				 +"<input type='hidden' name='student_email' value="+newstudent.getStudent_email()+">"
				 +"<input type='hidden' name='vertifycode' value="+newstudent.getVertifycode()+">"
				 +"<button type='submit'>提交驗證</button>" 
				 + "</form>"
				 + "</body>"
				 + "</html>",
				true);
		mailSender.send(mimeMessage);
		return baseLog;

	}

	public BaseLog getVertifyMail(String student_email) {

		return null;
	}

}
