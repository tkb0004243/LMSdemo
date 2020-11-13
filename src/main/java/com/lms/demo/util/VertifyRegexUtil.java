package com.lms.demo.util;

public class VertifyRegexUtil {

	private static final String EMAILREGEX= "^\\w{1,63}@[a-zA-Z0-9]{2,63}\\.[a-zA-Z]{2,63}(\\.[a-zA-Z]{2,63})?$";
	
	private static final String PWDREGEX="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,15}$";
	
	private static final String NAMEREGEX="^[\\u4e00-\\u9fa5a-zA-Z]+$";
	
	public static boolean matchEmailRegex(String email) {
		if(email!=null) {
			return email.matches(EMAILREGEX);
		}
		return false;
		
	}
	
	public static boolean matchPwdRegex(String password) {
		if(password!=null) {
			return password.matches(PWDREGEX);
		}
		return false;
	}
	
	public static boolean matchNameRegex(String name) {
		if(name!=null) {
			return name.matches(NAMEREGEX);
		}
		return false;
	}
}
