package com.lms.demo.service;

import javax.mail.MessagingException;

import com.lms.demo.model.BaseLog;
import com.lms.demo.model.Student;
import com.lms.demo.model.Teacher;

public interface VertifyMailService {

	BaseLog sendVertifyMail(Student newstudent) throws MessagingException;
	
	BaseLog sendVertifyMailToTeacher(Teacher newteacher) throws MessagingException;
	
	
	
}
