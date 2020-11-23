package com.lms.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="course_record")
public class Course_record {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COURSE_RECORD_ID")
	private Integer course_record_id;
	
	@OneToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;
	
	@OneToOne
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

	public Integer getCourse_record_id() {
		return course_record_id;
	}

	public void setCourse_record_id(Integer course_record_id) {
		this.course_record_id = course_record_id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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
	
}
