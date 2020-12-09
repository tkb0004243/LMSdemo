package com.lms.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="course_record")
public class Course_record {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COURSE_RECORD_ID")
	private Integer course_record_id;
	
	@Column(name="STUDENT_ID")
	private Integer student_id;
	
	@Column(name="COURSE_ID")
	private Integer course_id;
	
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

	public Integer getCourse_record_id() {
		return course_record_id;
	}

	public void setCourse_record_id(Integer course_record_id) {
		this.course_record_id = course_record_id;
	}

	
	
	

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
