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
	@Column(name="courseid")
	private Integer courseid;
	
	@Column(name="coursename")
	private String coursename;
	
	@Column(name="startdate")
	private String startdate;
	
	@Column(name="starttime")
	private String starttime;
	
	@Column(name="enddate")
	private String enddate;
	
	@Column(name="maxnumber")
	private Integer maxnumber;
	
	@Column(name="courseintroduce")
	private String courseintroduce;
	
	@Column(name="minnumber")
	private Integer minnumber;

	
	public Course(Integer courseid, String coursename, String startdate, String starttime, String enddate,
			Integer maxnumber, String courseintroduce, Integer minnumber) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.startdate = startdate;
		this.starttime = starttime;
		this.enddate = enddate;
		this.maxnumber = maxnumber;
		this.courseintroduce = courseintroduce;
		this.minnumber = minnumber;
	}
	
	public Course() {
		
	}

	public Integer getCourseid() {
		return courseid;
	}

	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
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

	public String getCourseintroduce() {
		return courseintroduce;
	}

	public void setCourseintroduce(String courseintroduce) {
		this.courseintroduce = courseintroduce;
	}

	public Integer getMinnumber() {
		return minnumber;
	}

	public void setMinnumber(Integer minnumber) {
		this.minnumber = minnumber;
	}
	
	
	
	
	

}
