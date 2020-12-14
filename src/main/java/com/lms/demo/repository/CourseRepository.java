package com.lms.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lms.demo.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	

	@Query(value="SELECT *FROM  lms.course  WHERE  CREATE_BY=?1 ",nativeQuery=true)
	public List<Course> findByCreate_by(String create_by);
	
	@Query(value="SELECT *FROM  lms.course  WHERE  COURSE_STATUS='0' ",nativeQuery=true)
	public List<Course> findCourseCanChoose();
	
}
