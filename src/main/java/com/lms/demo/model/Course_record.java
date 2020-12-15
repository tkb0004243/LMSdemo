package com.lms.demo.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;


@Entity
@Table(name="course_record")
@Data
public class Course_record {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COURSE_RECORD_ID")
	private Integer course_record_id;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COURSE_ID")
	private Course course;
	
	
	@Column(name="CREATE_BY")
	private String create_by;
	
	@Column(name="UPDATE_BY")
	private String update_by;
	
	@Column(name="CREATE_TIME")
	private String create_time;
	
	@Column(name="UPDATE_TIME")
	private String update_time;
	
	@Column(name="STATUS")   //設定 '0' 已選課 '1'取消選課 '2'課程已上完
	private String status;
	
	
	

	public Course_record() {
		
	}
	
	
	
}
