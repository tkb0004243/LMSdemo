package com.lms.demo.service.student;


import com.lms.demo.model.log.StudentLoginLog;

public interface StudentLoginService {
	
	StudentLoginLog checkLogin(String account,String password);

}
