package com.lms.demo.model.log;

public class BaseLog {
	
private String status;

private String message;

public BaseLog(String status, String message) {
	super();
	this.status = status;  //0:正常 1:異常
	this.message = message;
}

public BaseLog() {
	
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}
}
