package com.lms.demo.controller.admin.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lms.demo.model.log.LoginLog;

@Controller
@RequestMapping("/backstage/user")
public class TeacherUserBasicController {

@GetMapping(value={"","/"})
public String goUser(HttpSession session,Model model) {
	
	LoginLog teacherLoginLog=(LoginLog) session.getAttribute("user_information");
	
	model.addAttribute("user_information", teacherLoginLog.getTeacher());
	
	return "admin/user/user";
	
}
	
	
}
