package com.lms.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="teacher")
@Data
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TEACHER_ID")
	private Integer teacher_id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AUTHORITIES")
	private String authorities;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="CREATE_BY")
	private String create_by;
	
	@Column(name="CREATE_TIME")
	private String create_time;
	
	@Column(name="UPDATE_BY")
	private String update_by;
	
	@Column(name="UPDATE_TIME")
	private String update_time;
	
	@Column(name="VERTIFY_TIME")
	private String vertify_time;
	
	@Column(name="VERTIFY_CODE")
	private String vertify_code;

	public Teacher(Integer teacher_id, String name, String authorities, String email, String password, String status,
			String create_by, String create_time, String update_by, String update_time) {
		super();
		this.teacher_id = teacher_id;
		this.name = name;
		this.authorities = authorities;
		this.email = email;
		this.password = password;
		this.status = status;
		this.create_by = create_by;
		this.create_time = create_time;
		this.update_by = update_by;
		this.update_time = update_time;
	}

	public Teacher() {
		super();
	}

	
}
