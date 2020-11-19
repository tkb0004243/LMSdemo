package com.lms.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
 
 public void addViewControllers(ViewControllerRegistry registry) {
	 registry.addViewController("/login").setViewName("login");
	 registry.addViewController("/showcourse").setViewName("showcourse");
	 registry.addViewController("/user").setViewName("user");
	 registry.addViewController("/error").setViewName("error");
	 registry.addViewController("/makecourse").setViewName("makecourse");
	 registry.addViewController("/adminlogin").setViewName("adminlogin");
 }
}