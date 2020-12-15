package com.lms.demo.timer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import com.lms.demo.service.timer.DailyTimerService;





@Component
public class ScheduledTasks {
	
	private static final String CRON_SCHEDILED_STRING=" 0 30 10 * * ? "; //每日10:30執行一次
	
	@Autowired
	DailyTimerService dailyTimerService;
	

	@Scheduled(cron = CRON_SCHEDILED_STRING)
	public void sendMailToStudentWhoChooseCourseDeleted() {
		dailyTimerService.sendMailToStudentWhoChooseCourseDeleted();
	}
}
