package com.lms.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lms.demo.model.Teacher;
import com.lms.demo.model.TeacherLoginLog;
import com.lms.demo.repository.TeacherRepository;
import com.lms.demo.service.teacher.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	
	public TeacherLoginLog login(String email,String password) {
		TeacherLoginLog loginLog=new TeacherLoginLog();
		List<Teacher> result=teacherRepository.findByEmail(email);
		if(result!=null) {
			Teacher vertify_ty=result.get(0);
			if(vertify_ty.getPassword().equals(password)) {
				loginLog.setTeacher(vertify_ty);
				return loginLog;
			}
			loginLog.setStatus("1");
			loginLog.setMessage("pwd is wrong");
			return loginLog;
			
			
		}
		loginLog.setStatus("1");
		loginLog.setMessage("account is not exist");
		return loginLog;
	}

	public void signup(Teacher teacher) {
		teacherRepository.save(teacher);
	}

}
