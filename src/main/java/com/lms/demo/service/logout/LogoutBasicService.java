package com.lms.demo.service.logout;

import javax.servlet.http.HttpSession;

import com.lms.demo.model.log.LogoutLog;

public interface LogoutBasicService {

	public LogoutLog logout(HttpSession session);
}
