package com.lms.demo.model.log;

public class LogoutLog extends BaseLog {

	private String authority;
	
	private String account;
	
	
	public LogoutLog() {
		
	}


	public String getAuthority() {
		return authority;
	}


	public void setAuthority(String authority) {
		this.authority = authority;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}
	
	
	
}
