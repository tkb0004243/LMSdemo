package com.lms.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lms.demo.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	@Query(value="select *from teacher t where t.EMAIL=?1",nativeQuery=true)
	List<Teacher> findByEmail(String email);
}
