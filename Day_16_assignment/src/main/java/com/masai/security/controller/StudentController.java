package com.masai.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.security.entity.Course;
import com.masai.security.entity.Student;
import com.masai.security.service.CourseService;
import com.masai.security.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService sService;
	
	@Autowired
	private CourseService cService;
	
	@PostMapping("/students")
	public ResponseEntity<Student> registerAsStduent(@RequestBody Student student)
	{
		return new ResponseEntity<Student>(sService.addStudent(student), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses()
	{
		return new ResponseEntity<List<Course>>(cService.getAllCourses(), HttpStatus.ACCEPTED);
	}

}
