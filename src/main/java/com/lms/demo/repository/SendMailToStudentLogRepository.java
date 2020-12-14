package com.lms.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lms.demo.model.log.SendMailToStudentLog;


public interface SendMailToStudentLogRepository extends JpaRepository<SendMailToStudentLog, Integer> {
	
	@Query(value=" SELECT * FROM lms.send_mail_log WHERE STATUS = ?1 ",nativeQuery = true)
	public List<SendMailToStudentLog> findByStauts(String status);

}
