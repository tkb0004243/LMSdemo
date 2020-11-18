package com.lms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.demo.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
