package com.masai.security.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.security.entity.Course;
import com.masai.security.entity.Student;
import com.masai.security.exception.CourseException;
import com.masai.security.exception.StudentException;
import com.masai.security.service.CourseService;
import com.masai.security.service.StudentService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private StudentService sService;
	
	@Autowired
	private CourseService cService;
	
	@PostMapping("/courses")
	public ResponseEntity<Course> createNewCourse(@RequestBody Course course)
	{
		return new ResponseEntity<Course>(cService.addcourse(course), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/courses/{courseid}")
	public ResponseEntity<Course> deleteCourse(@PathVariable("courseid") Long courseid) throws CourseException
	{
		return new ResponseEntity<Course>(cService.deleteCourse(courseid), HttpStatus.OK);
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses()
	{
		return new ResponseEntity<List<Course>>(cService.getAllCourses(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		
		return new ResponseEntity<List<Student>>(sService.getStudents(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/students/{courseid}")
	public ResponseEntity<List<Student>> getAllStudentsFromCourse(@PathVariable("courseid") Long courseid) throws CourseException{
		
		return new ResponseEntity<List<Student>>(sService.getStudentByCourse(courseid), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/students/{studentid}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("studentid") Long studentid) throws StudentException
	{
		return new ResponseEntity<Student>(sService.deleteStudent(studentid), HttpStatus.OK);
	}

	
	@PutMapping("/students")
	public ResponseEntity<String> addStudentToCourse(@RequestParam Long studentid ,@RequestParam Long courseid) throws StudentException
	{
		return new ResponseEntity<String>(sService.addToCourse(studentid, courseid), HttpStatus.ACCEPTED);
	}
}
