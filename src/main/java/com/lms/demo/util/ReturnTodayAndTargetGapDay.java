package com.lms.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReturnTodayAndTargetGapDay {

	
	public static Integer getGapDay(String target_date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today_string = sdf.format(new Date());
		Date today_new=new SimpleDateFormat("yyyy-MM-dd").parse(today_string);
		Date compare_date=new SimpleDateFormat("yyyy-MM-dd").parse(target_date);
		long gap_minisecond=compare_date.getTime()-today_new.getTime();
		long one_day_minisecond=86400000;
		Integer gap_day=(int) (gap_minisecond/one_day_minisecond);
		
		return gap_day;
		
	}
	
}
