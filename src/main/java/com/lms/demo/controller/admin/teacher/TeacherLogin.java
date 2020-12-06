package com.lms.demo.controller.admin.teacher;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lms.demo.model.log.LoginLog;
import com.lms.demo.service.teacher.TeacherService;

@Controller
@RequestMapping(value="/backstage/login")
public class TeacherLogin {
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping(value={"/",""})
	public String gologin(HttpServletRequest request,Model model) {
		
		return "admin/login/teacherLogin";
		
	}
	
	@PostMapping(value={"/",""})
	public String login(HttpServletRequest request,Model model,HttpSession session) {
		
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		
		LoginLog teachetLoginLog=teacherService.login(account, password);
		
		model.addAttribute("system_message", teachetLoginLog);
		if("0".equals(teachetLoginLog.getStatus())) {
			session.setAttribute("user_information", teachetLoginLog);
			model.addAttribute("path", "/backstage/user");
		}
		else {
			model.addAttribute("path", "/backstage/login");
		}
		return "/admin/path";
		
	}
	
	
	

}
