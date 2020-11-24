package com.lms.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lms.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	@Query(value="SELECT *FROM student S WHERE S.EMAIL=?1",nativeQuery=true)
	List<Student> findByEmail(String email);
	
	
	
}
