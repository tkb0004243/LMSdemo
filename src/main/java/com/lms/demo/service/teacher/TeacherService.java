package com.lms.demo.service.teacher;



import com.lms.demo.model.Teacher;
import com.lms.demo.model.TeacherLoginLog;


public interface TeacherService {

	TeacherLoginLog login(String email,String password);
	
	void signup(Teacher teacher);
}
