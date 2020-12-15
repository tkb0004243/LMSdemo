package com.lms.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lms.demo.model.log.SendMailToStudentLog;

import lombok.Data;

@Entity
@Table(name="course")
@Data
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COURSE_ID")
	private Integer course_id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="STARTDATE")
	private String startdate;
	
	@Column(name="STARTTIME")
	private String starttime;
	
	@Column(name="ENDTIME")
	private String endtime;
	
	@Column(name="ENDDATE")
	private String enddate;
	
	@Column(name="MAXNUMBER")
	private Integer maxnumber;
	
	@Column(name="MINNUMBER")
	private Integer minnumber;
	
	@Column(name="INTRODUCE")
	private String introduce;
	
	@Column(name="CREATE_BY")
	private String create_by;
	
	@Column(name="UPDATE_BY")
	private String update_by;
	
	@Column(name="CREATE_TIME")
	private String create_time;
	
	@Column(name="UPDATE_TIME")
	private String update_time;
	
	@Column(name="NOW_STUDENT_NUMBER")
	private Integer now_student_number;
	
	@Column(name="COURSE_STATUS")   //0:正常開課 1：教師已取消課程 2：課程進行中 3：課程已經完結
	private String course_status;
	
	
	@JsonManagedReference
	@OneToMany(mappedBy = "course")
	private List<Course_record> course_records;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "course")
	private List<SendMailToStudentLog> sendMailToStudentLogs;
	

	

	public Course() {
		super();
	}

}
