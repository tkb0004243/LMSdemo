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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lms.demo.model.log.SendMailToStudentLog;

import lombok.Data;

@Entity
@Table(name="student")
@Data
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="STUDENT_ID")
	private Integer student_id;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="BIRTHDAY")
	private String birthday;
	
	@Column(name="AUTHORITIES") //0:student 1:teacher
	private String authorities;
	
	@Column(name="STATUS")  //設置狀態 0正常 1未驗證
	private String status;
	
	@Column(name="CREATE_TIME") //SQL內自動產生
	private String create_time;
	
	@Column(name="UPDATE_TIME") //SQL內自動產生
	private String update_time;
	
	@Column(name="CREATE_BY") 
	private String create_by;
	
	@Column(name="UPDATE_BY") 
	private String update_by;
	
	
	@Column(name="VERTIFY_EMAIL_TIME")  
	private String vertify_email_time;
	
	@Column(name="VERTIFY_CODE") //儲存要比對的驗證碼
	private String vertify_code;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "student")
	private List<Course_record> course_records;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "student")
	private List<SendMailToStudentLog> sendMailToStudentLogs;
	

	public Student(Integer student_id, String email, String password, String name, String birthday, String authorities,
			String status, String create_time, String update_time, String create_by, String update_by,
			String vertify_email_time, String vertify_code) {
		super();
		this.student_id = student_id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.authorities = authorities;
		this.status = status;
		this.create_time = create_time;
		this.update_time = update_time;
		this.create_by = create_by;
		this.update_by = update_by;
		this.vertify_email_time = vertify_email_time;
		this.vertify_code = vertify_code;
	}

	public Student() {
		super();
	}

	
	
	
	
	
	
}
