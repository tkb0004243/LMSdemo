package com.lms.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
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

	public Course(Integer course_id, String name, String startdate, String starttime,String endtime, String enddate, Integer maxnumber,
			Integer minnumber, String introduce, String create_by, String update_by, String create_time,
			String update_time) {
		super();
		this.course_id = course_id;
		this.name = name;
		this.startdate = startdate;
		this.starttime = starttime;
		this.endtime=endtime;
		this.enddate = enddate;
		this.maxnumber = maxnumber;
		this.minnumber = minnumber;
		this.introduce = introduce;
		this.create_by = create_by;
		this.update_by = update_by;
		this.create_time = create_time;
		this.update_time = update_time;
	}

	public Course() {
		super();
	}

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public Integer getMaxnumber() {
		return maxnumber;
	}

	public void setMaxnumber(Integer maxnumber) {
		this.maxnumber = maxnumber;
	}

	public Integer getMinnumber() {
		return minnumber;
	}

	public void setMinnumber(Integer minnumber) {
		this.minnumber = minnumber;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
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

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	
	

	
	
	
	
	

}
