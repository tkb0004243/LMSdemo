package com.lms.demo.util;


public class VertifyCodeMake {
	
	private static final String[] vertifystr={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9"};
	
	public static String returnVertifyCode() {
		String result="";
		for(int i=0;i<4;i++) {
			int r=(int)(Math.random()*36);
			String x=vertifystr[r];
			result+=x;
		}
		return result;
		
	}
	

}
