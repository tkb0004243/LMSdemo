package com.lms.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
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
	
	@OneToOne(mappedBy="student")
	private Course_record course_record; 

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

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getVertify_email_time() {
		return vertify_email_time;
	}

	public void setVertify_email_time(String vertify_email_time) {
		this.vertify_email_time = vertify_email_time;
	}

	public String getVertify_code() {
		return vertify_code;
	}

	public void setVertify_code(String vertify_code) {
		this.vertify_code = vertify_code;
	}

	
	
	
	
	
	
}
