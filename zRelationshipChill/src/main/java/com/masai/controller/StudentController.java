package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Course;
import com.masai.service.CourseService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	
	private CourseService cService;
	
	@GetMapping("/hello")
	public String walcome() {
		return "HEllO";
	}
	@PostMapping("/addCourse")
	public ResponseEntity<Course> registerCourse(@RequestBody Course course){
		
		Course addCourse = cService.registerNewCourse(course);
		return new  ResponseEntity<Course>(addCourse,HttpStatus.CREATED);
	}
}
