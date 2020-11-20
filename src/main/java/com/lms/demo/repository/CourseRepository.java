package com.lms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.demo.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	
}
