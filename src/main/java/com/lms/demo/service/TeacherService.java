package com.lms.demo.service;


import com.lms.demo.model.LoginLog;
import com.lms.demo.model.Teacher;


public interface TeacherService {

	LoginLog login(String email,String password);
	
	void signup(Teacher teacher);
}
