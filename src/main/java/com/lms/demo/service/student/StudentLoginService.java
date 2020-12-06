package com.lms.demo.service.student;

import com.lms.demo.model.log.LoginLog;

public interface StudentLoginService {
	
	LoginLog checkLogin(String account,String password);

}
