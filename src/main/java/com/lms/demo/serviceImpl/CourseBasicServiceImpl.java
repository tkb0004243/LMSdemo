package com.lms.demo.serviceImpl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.demo.model.Course;
import com.lms.demo.model.Course_record;
import com.lms.demo.model.Student;
import com.lms.demo.model.Teacher;
import com.lms.demo.model.log.BaseLog;
import com.lms.demo.model.log.CourseLog;
import com.lms.demo.repository.CourseRepository;
import com.lms.demo.repository.Course_recordRepository;
import com.lms.demo.repository.StudentRepository;
import com.lms.demo.service.course.CourseBasicService;
import com.lms.demo.service.mail.VertifyMailService;
import com.lms.demo.util.ReturnTodayAndTargetGapDay;

@Service
public class CourseBasicServiceImpl implements CourseBasicService {

	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	Course_recordRepository course_recordRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	VertifyMailService vertifyMailService;
	
	
	
	
	
	@Override
	public CourseLog checkAddCourse(Course newcourse) {
		CourseLog courseAddLog=new CourseLog();
		if(newcourse!=null) {
			
			courseAddLog.setStatus("0");
			courseAddLog.setMessage("課程創建成功");
			courseAddLog.setCourse(newcourse);
			
			
		}
		else {
			courseAddLog.setStatus("1");
			courseAddLog.setMessage("課程創建失敗");
		}
		
		return courseAddLog;
	}

	@Override
	public CourseLog addCourse(CourseLog courseAddLog,Teacher teacher) {
		if("0".equals(courseAddLog.getStatus())) {
			
			courseAddLog.getCourse().setCreate_by(teacher.getName());
			courseAddLog.getCourse().setNow_student_number(0);
			courseRepository.save(courseAddLog.getCourse());
			return courseAddLog;
		}
		courseAddLog.setMessage("課程寫入資料庫失敗");
		return courseAddLog;
	}

	@Override
	public List<Course> searchAllCourse() {
		List<Course> allCourses=courseRepository.findAll();
		return allCourses;
	}

	@Override
	public CourseLog deleteCourse(Course delete_course) {
		CourseLog courseLog=new CourseLog();
		
		try {
			courseRepository.delete(delete_course);
			course_recordRepository.deleteByCourse_id(delete_course.getCourse_id());
			courseLog.setStatus("0");
			courseLog.setMessage("課程成功刪除");
			courseLog.setCourse(delete_course);
		}
		catch (Exception e) {
			courseLog.setStatus("1");
			courseLog.setMessage("課程刪除失敗");
		}
		return courseLog;
		
	}

	@Override
	public CourseLog checkDeleteCourse(Course delete_course) throws ParseException {
		CourseLog courseLog=new CourseLog();
		
		Integer gap_day=ReturnTodayAndTargetGapDay.getGapDay(delete_course.getStartdate());
		System.out.println("gap_day:"+gap_day);
		if(gap_day<3) {
			courseLog.setStatus("1");
			courseLog.setMessage("距離開課日少於3天");
		}
		else {
			courseLog.setStatus("0");
			courseLog.setMessage("可以刪除課程");
			courseLog.setCourse(delete_course);
		}
		
		return courseLog;
	}

	@Override
	public CourseLog sendLetterToDeleteCourseStudent(Course delete_course) {
		
		CourseLog courseLog=new CourseLog();
		List<Integer> ids=new ArrayList<Integer>();
		List<Course_record> resultsCourse_records=course_recordRepository.findByCourse_id(delete_course.getCourse_id()); //撈出選課紀錄中與欲刪除課程有關紀錄
		ids=resultsCourse_records.stream().map(records->records.getStudent_id()).collect(Collectors.toList());
		List<Student> students=studentRepository.findAllById(ids);
		if(students!=null&&students.size()>0) {
			for(Student student:students) {
				BaseLog mailsend_result=vertifyMailService.sendDeleteCourseToStudent(student, delete_course);
				if("1".equals(String.valueOf(mailsend_result.getStatus()))) {
					
					courseLog.setStatus("1");
					courseLog.setMessage("信件寄給學生失敗！");
					break;
				}
				else {
					
					courseLog.setStatus("0");
					courseLog.setMessage("信件寄送學生成功！");
				}
				
			}
			
			return courseLog;
		}
		
		courseLog.setStatus("0");
		courseLog.setMessage("無學生選此課程");
		
		return courseLog;
	}

}
