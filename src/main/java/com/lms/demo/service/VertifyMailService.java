package com.lms.demo.service;

import javax.mail.MessagingException;

import com.lms.demo.model.BaseLog;
import com.lms.demo.model.Student;

public interface VertifyMailService {

	BaseLog sendVertifyMail(Student newstudent) throws MessagingException;
	
	BaseLog getVertifyMail(String student_email);
}
