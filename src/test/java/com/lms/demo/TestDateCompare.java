package com.lms.demo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.convert.JodaTimeConverters.DateTimeToDateConverter;

import com.lms.demo.util.ReturnTodayAndTargetGapDay;

@SpringBootTest
public class TestDateCompare {

	
	@Test
	void Compare() throws ParseException {
		String compare_dateString="2020-12-01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today_string = sdf.format(new Date());
		Date compare_date=new SimpleDateFormat("yyyy-MM-dd").parse(compare_dateString);
		
		Date compare_date_3=new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-04");
		
		Date compare_date_6=new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-07");
		
		Date today_new=new SimpleDateFormat("yyyy-MM-dd").parse(today_string);
		
		Calendar today = Calendar.getInstance();
		
	
		System.out.println( today_new.getTime()-compare_date_6.getTime());
			
	}
	
	
}
