package com.lms.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.model.Course;
import com.lms.demo.model.Course_record;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.model.log.SendMailToStudentLog;
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.repository.SendMailToStudentLogRepository;
import com.lms.demo.service.course.CourseBasicService;
import com.lms.demo.service.mail.VertifyMailService;
import com.lms.demo.service.timer.DailyTimerService;

@Service
public class DailyTimerServiceImpl implements DailyTimerService {
	
	@Autowired
	SendMailToStudentLogRepository sendMailToStudentLogRepository;
	
	@Autowired
	VertifyMailService vertifyMailService;
	
	
	

	@Override
	public void sendMailToStudentWhoChooseCourseDeleted() {
		List<SendMailToStudentLog> getMailToStudentLogs=sendMailToStudentLogRepository.findByStauts("0"); //0是尚未寄信的
		
		if(getMailToStudentLogs!=null&&getMailToStudentLogs.size()>0) {
			for(SendMailToStudentLog mailToStudentLog:getMailToStudentLogs) {
				BaseLog baseLog=vertifyMailService.sendDeleteCourseToStudent(mailToStudentLog.getStudent(), mailToStudentLog.getCourse());
				if("0".equals(String.valueOf(baseLog.getStatus()))) {
					mailToStudentLog.setStatus("1");	
				}
				else {
					mailToStudentLog.setStatus("0");
				}
				mailToStudentLog.setMessage(baseLog.getMessage());
				sendMailToStudentLogRepository.save(mailToStudentLog);
			}
		}
		
		
		
		
		
		
		
		
	
	}

}
