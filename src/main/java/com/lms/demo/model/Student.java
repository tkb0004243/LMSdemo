package com.lms.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private Integer student_id;
	
	@Column(name="student_email")
	private String student_email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="birthday")
	private String birthday;
	
	@Column(name="authorities")
	private String authorities;
	
	@Column(name="status")
	private String status;
	
	@Column(name="create_time") //SQL內自動產生
	private String create_time;
	
	@Column(name="update_time") //SQL內自動產生
	private String update_time;
	
	@Column(name="vertify_email_time") 
	private String vertify_email_time;

	public Student(String student_email, String password, String name, String birthday, String authorities,
			String status, String vertify_email_time) {
		super();
		this.student_email = student_email;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.authorities = authorities;
		this.status = status;
		this.vertify_email_time = vertify_email_time;
	}
	
	public Student() {
		
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getVertify_email_time() {
		return vertify_email_time;
	}

	public void setVertify_email_time(String vertify_email_time) {
		this.vertify_email_time = vertify_email_time;
	}
	
	
	
	
	
}
