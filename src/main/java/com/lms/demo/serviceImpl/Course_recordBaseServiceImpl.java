package com.lms.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.model.Course;
import com.lms.demo.model.Course_record;
import com.lms.demo.model.Student;
import com.lms.demo.model.log.Course_recordLog;
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.repository.Course_recordRepository;
import com.lms.demo.service.course_record.Course_recordBaseService;

@Service
public class Course_recordBaseServiceImpl implements Course_recordBaseService {
	
	@Autowired
	Course_recordRepository course_recordRepository;
	
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Course_recordLog add(Student student, Course course) {
		Course_record new_course_record=new Course_record();
		Course_recordLog course_recordLog=new Course_recordLog();
		
		if(course.getMaxnumber()>course.getNow_student_number()) { //當現有選課人數小於課程上限人數才可以選課
			
			new_course_record.setStatus("0");
			course_recordRepository.save(new_course_record);
			
			//回傳選課狀態log
			course_recordLog.setStatus("0");
			course_recordLog.setMessage("選課成功");
			course_recordLog.setCourse_record(new_course_record);
			return course_recordLog;
		}
		course_recordLog.setStatus("1");
		course_recordLog.setMessage("修課人數達到上限,選課失敗");
		return course_recordLog;
	}

	

	@Override 
	public Course_recordLog checkAddCourseRecord(Student student, Course course) { 
		Course_recordLog course_recordLog=new Course_recordLog();
		List<Course_record> results=course_recordRepository.findByCourseIDAndStudentID(course.getCourse_id(),student.getStudent_id());
		if(results!=null&&results.size()>0) {
			for(Course_record record : results) {
				if(record.getCourse_record_id().equals(course.getCourse_id())) { //與學生已選取的課程重複
					course_recordLog.setStatus("1");
					course_recordLog.setMessage("課程選取不得重複");
					return course_recordLog;
				}
			}
			
			if(!"0".equals(course.getCourse_status())) { //課程狀態為不可以選擇
				course_recordLog.setStatus("1");
				course_recordLog.setMessage("課程狀態為不可選擇");
				return course_recordLog;
			}
			
		
		}
		course_recordLog.setStatus("0");
		course_recordLog.setMessage("此課程可以選擇");
		course_recordLog.setStudent(student);
		course_recordLog.setCourse(course);
		
		return course_recordLog;
	}



	@Override
	public List<Optional<Course>> getStudentChooseCourse(Student student) {
		List<Optional<Course>> result=new ArrayList<Optional<Course>>();
		Integer student_id=student.getStudent_id();
		List<Course_record> searchs=course_recordRepository.findByStudent_id(student_id);
		if(searchs!=null&&searchs.size()>0) {
			for( Course_record record :searchs) {
				Optional<Course> course=courseRepository.findById(record.getCourse_id());
				result.add(course);
				return result;
			}
			
		}
		return null;
	

}
}
