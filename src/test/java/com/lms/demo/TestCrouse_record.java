package com.lms.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.lms.demo.model.Course;
import com.lms.demo.model.Course_record;
import com.lms.demo.model.Student;
import com.lms.demo.repository.Course_recordRepository;
import com.lms.demo.service.course_record.Course_recordBaseService;
import com.sun.xml.bind.v2.runtime.output.StAXExStreamWriterOutput;

@SpringBootTest
public class TestCrouse_record {
	
	@Autowired
	Course_recordRepository course_recordRepository;
	
	@Autowired
	Course_recordBaseService course_recordBaseService;
	
	 void Testsave() {
		Course_record course_record=new Course_record();
		
		Course course=new Course();
		Student student=new Student();
		
		course_record.setCourse(course);
		course_record.setStudent(student);
		
		course_recordRepository.save(course_record);

}
	
	void TestfindByCourseIDAndStudentID() {
		List<Course_record> result=course_recordRepository.findByCourseIDAndStudentID(1,8);
		if(result!=null) {
			System.out.println(result.get(0).getCourse_record_id());
			System.out.println("測試成功");
		}
		else {
			System.out.println("測試失敗");
		}
		
	}
	

	void TestcountNow_Student_Number() {
		int count=course_recordRepository.countNow_Student_Number(1);
		System.out.println("count:"+count);
	}
	
	
	void TestgetStudentChooseCourse_id() {
		Student student=new Student();
		student.setStudent_id(3);
		List<Integer> result=course_recordBaseService.getStudentChooseCourse_id(student);
		System.out.println(result);
	}
}
