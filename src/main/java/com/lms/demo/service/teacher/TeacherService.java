package com.lms.demo.service.teacher;



import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.TeacherLoginLog;
import com.lms.demo.model.log.TeacherSignUpLog;


public interface TeacherService {

	TeacherLoginLog login(String email,String password);
	
	void signup(Teacher teacher);
	
	TeacherSignUpLog getmail(List<Teacher> result,HttpServletRequest request) throws ParseException;
}
