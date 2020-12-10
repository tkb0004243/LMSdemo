package com.lms.demo.service.mail;

import java.text.ParseException;

import javax.mail.MessagingException;

import com.lms.demo.model.Student;
import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.model.log.SignUpLog;


public interface VertifyMailService {

	BaseLog sendVertifyMailToStudent(Student newstudent) throws MessagingException;
	
	BaseLog sendVertifyMailToTeacher(Teacher newteacher) throws MessagingException;

	SignUpLog checkReturnVertifyMail(String student_email, String vertifycode) throws ParseException;
	
	BaseLog reSendVertifyMail(Student student) throws MessagingException; //將student從資料庫裡撈出,然後更正
	
	
	
}
