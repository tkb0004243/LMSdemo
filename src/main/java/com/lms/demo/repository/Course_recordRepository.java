package com.lms.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lms.demo.model.Course_record;



public interface Course_recordRepository extends JpaRepository<Course_record, Integer> {

	@Query(value="SELECT *FROM course_record  WHERE  COURSE_ID=?1 AND STUDENT_ID=?2",nativeQuery=true)
	public List<Course_record> findByCourseIDAndStudentID(Integer course_id,Integer student_id);
}
