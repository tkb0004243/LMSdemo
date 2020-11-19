package com.lms.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lms.demo.model.Student;
import com.lms.demo.model.Teacher;
import com.lms.demo.repository.TeacherRepository;
import com.lms.demo.service.TeacherService;
import com.lms.demo.util.VertifyCodeMake;

@Controller
public class BackstageSignUpController {
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@PostMapping("/backstage/signup")
	public String signup(@ModelAttribute Teacher newteacher)
	{	newteacher.setStatus("1");
		newteacher.setAuthorities("teacher");
		newteacher.setVertify_code(VertifyCodeMake.returnVertifyCode());
		teacherService.signup(newteacher);
		return "adminlogin";
	}
	
	@PostMapping("/backstage/getmail")
	public String getmail(HttpServletRequest request,Model model) throws ParseException {
		String teacher_email=request.getParameter("teacher_email");
		String vertifycode=request.getParameter("vertifycode");
		
		List<Teacher> result=teacherRepository.findByEmail(teacher_email);
		if(result!=null) {
			Teacher result_ts=result.get(0);
			String trans_ts=result_ts.getVertify_time();
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date ver_date=sdf.parse(trans_ts);
			Date today=new Date();
			long from=today.getTime();
			long to=ver_date.getTime();
			long gap=from-to;
			if(result_ts.getVertify_code().equals(vertifycode)&&gap<(1000*60*60)) {
			result.get(0).setStatus("0");
			teacherRepository.save(result.get(0));
			return "adminlogin";
			}
			else {
				model.addAttribute("error", "帳號錯誤或驗證時間超時");
				return "error";
			}
			
		}
		model.addAttribute("error", "查無此帳號");
		return "error";
		
		
	}
	}
	

