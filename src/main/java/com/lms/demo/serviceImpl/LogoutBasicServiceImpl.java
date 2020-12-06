package com.lms.demo.serviceImpl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.lms.demo.model.log.LoginLog;
import com.lms.demo.model.log.LogoutLog;
import com.lms.demo.service.logout.LogoutBasicService;

@Service
public class LogoutBasicServiceImpl implements  LogoutBasicService{

	@Override
	public LogoutLog logout(HttpSession session) {
		LogoutLog logoutLog=new LogoutLog();
		if("teacher".equals(((LoginLog)session.getAttribute("user_information")).getAuthority())) {
			logoutLog.setStatus("0");
			logoutLog.setMessage("老師已退出");
			logoutLog.setAuthority("teacher");
			session.removeAttribute("user_information");
		}
		else {
			logoutLog.setStatus("0");
			logoutLog.setMessage("學生已退出");
			logoutLog.setAuthority("student");
			session.removeAttribute("user_information");
		}
		return logoutLog;
		
	}

}
