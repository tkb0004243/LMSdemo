package com.lms.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.model.Student;
import com.lms.demo.model.StudentLoginLog;
import com.lms.demo.repository.StudentRepository;
import com.lms.demo.service.student.StudentLoginService;

@Service
public class StudentLoginServiceImpl implements StudentLoginService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public StudentLoginLog checkLogin(String account, String password) {
		StudentLoginLog studentLoginLog=new StudentLoginLog();
		List<Student> result=studentRepository.findByEmail(account);
		if(result!=null)
		{
			if(result.get(0).getPassword().equals(password)) //驗證密碼
			{
				if("1".equals(result.get(0).getStatus())){
					studentLoginLog.setStatus("1"); // 0:正常 1:異常
					studentLoginLog.setMessage("帳號未驗證");
					return studentLoginLog;
					
				}
				studentLoginLog.setStatus("0");
				studentLoginLog.setMessage("帳號密碼正確");
				studentLoginLog.setStudent(result.get(0));
				return studentLoginLog;
			}
			
			
			else
			{
				studentLoginLog.setStatus("1"); //0:正常 1:異常
				studentLoginLog.setMessage("密碼錯誤");
				return studentLoginLog;
			}
			
			
		}
		else 
		{
			studentLoginLog.setStatus("1"); //0:正常 1:異常
			studentLoginLog.setMessage("查無此帳號");
			return studentLoginLog;
		}
		
		
	}

}
