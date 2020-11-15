package com.lms.demo.model;

public class LoginLog {
	
	private Integer status;
	//正常為0
	//有問題設1
	private String message;

	public LoginLog(Integer status,String message) {
		super();
		this.status=status;
		this.message = message;
	}
	
	public LoginLog() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
