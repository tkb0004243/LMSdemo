package com.lms.demo.controller.admin.teacher;

import java.lang.management.MemoryType;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.TeacherLoginLog;
import com.lms.demo.service.teacher.TeacherService;

@Controller
@RequestMapping(value="/teacher/login",method= {RequestMethod.GET,RequestMethod.POST})
public class TeacherLogin {
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping(value="/",method = {RequestMethod.GET,RequestMethod.POST} )
	

}
