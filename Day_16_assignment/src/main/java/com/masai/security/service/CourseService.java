package com.masai.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.security.entity.Course;
import com.masai.security.exception.CourseException;
import com.masai.security.respository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository cRepository;
	
	
	//to add new course
	public Course addcourse(Course course)
	{
		return cRepository.save(course);
	}
	
	
	//to delete course
	public Course deleteCourse(Long id) throws CourseException
	{
		Optional<Course> cOpt = cRepository.findById(id);
		if(cOpt.isPresent())
		{
			Course course = cOpt.get();
			cRepository.delete(course);
			return course;
		}
		else
		{
			throw new CourseException("Course is not available with provided id: "+id);
		}
	}
	
	
	//to ger all courses
	public List<Course> getAllCourses()
	{
		return cRepository.findAll();
	}
	
	

}
