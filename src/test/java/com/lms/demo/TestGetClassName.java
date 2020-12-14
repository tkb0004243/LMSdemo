package com.lms.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.lms.demo.model.Teacher;


@SpringBootTest(classes = DemoApplication.class)
public class TestGetClassName {

	@Test
	void getName() {
		Teacher ta=new Teacher();
		
		System.out.println(ta.getClass().getName());
	}
}
