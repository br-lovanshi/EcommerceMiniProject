package com.masai.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Course;
import com.masai.entity.Student;
import com.masai.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepo cDao;
	
	@Override
	public Course registerNewCourse(Course course) {
		
		Set<Student> students = course.getStudents();
		
		for(Student st : students ) {
			
			st.getCourses().add(course);
			
		}
		
		
		return cDao.save(course);
	}

}
