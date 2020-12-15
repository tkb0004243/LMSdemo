package com.lms.demo.model.log;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lms.demo.model.Course;
import com.lms.demo.model.Student;

import lombok.Data;

@Entity
@Table(name="send_mail_log")
@Data
public class SendMailToStudentLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LOG_ID")
	private Integer log_id;
	
	@Column(name="STATUS") //0:尚未寄信 1：已經寄信
	private String status;
	
	@Column(name="MESSAGE")
	private String message;
	
	@Column(name="CREATE_BY")
	private String create_by;
	
	@Column(name="UPDATE_BY")
	private String update_by;
	
	@Column(name="CREATE_TIME")
	private String create_time;
	
	@Column(name="UPDATE_TIME")
	private String update_time;
	
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="COURSE_ID")
	private Course course;

}
