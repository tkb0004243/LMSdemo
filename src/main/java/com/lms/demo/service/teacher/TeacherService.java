package com.lms.demo.service.teacher;



import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.model.log.LoginLog;
import com.lms.demo.model.log.SignUpLog;



public interface TeacherService {

	public LoginLog login(String email,String password);
	
	public void signup(Teacher teacher);
	
	public SignUpLog getmail(List<Teacher> result,HttpServletRequest request) throws ParseException;
	
	
}
