package com.lms.demo.service.mail;

import java.text.ParseException;

import javax.mail.MessagingException;

import com.lms.demo.model.BaseLog;
import com.lms.demo.model.Student;
import com.lms.demo.model.StudentSignUpLog;
import com.lms.demo.model.Teacher;

public interface VertifyMailService {

	BaseLog sendVertifyMail(Student newstudent) throws MessagingException;
	
	BaseLog sendVertifyMailToTeacher(Teacher newteacher) throws MessagingException;

	StudentSignUpLog checkReturnVertifyMail(String student_email, String vertifycode) throws ParseException;
	
	
	
}
