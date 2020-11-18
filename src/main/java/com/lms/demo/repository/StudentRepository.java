package com.lms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	
}
