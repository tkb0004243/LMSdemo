package com.lms.demo.model;

public class LoginLog {
	
	private String status="";

	public LoginLog(String status) {
		super();
		this.status = status;
	}
	
	public LoginLog() {
		
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
