package com.masai.security.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.security.entity.Course;
import com.masai.security.entity.Student;
import com.masai.security.exception.CourseException;
import com.masai.security.exception.StudentException;
import com.masai.security.respository.CourseRepository;
import com.masai.security.respository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository sRepository;
	
	@Autowired
	private CourseRepository cRepository;
	
	
	//add student
	public Student addStudent(Student student)
	{
		return sRepository.save(student);
	}
	
	
	//get all students
	public List<Student> getStudents()
	{
		List<Student> students = sRepository.findAll();
		return students;
	}
	
	
	//get students by course
	public List<Student> getStudentByCourse(Long courseId) throws CourseException
	{
		Course course = cRepository.findById(courseId).get();
		if(course==null)
		{
			throw new CourseException("Course is not present with this id");
		}
		return sRepository.findByCourses(course);
	}
	
	
	//delete student
	public Student deleteStudent(Long studentId) throws StudentException
	{
		Optional<Student> st =  sRepository.findById(studentId);
		if(st.isPresent())
		{
//			sRepository.delete(st.get());
			sRepository.deleteById(st.get().getId());
			return st.get();
		}
		else
		{
			throw new StudentException("Student not found with id: "+studentId);
		}
	}
	
	
	//assign or choose course for student
	public String addToCourse(Long studentid, Long courseid) throws StudentException
	{
		Optional<Student> optStu = sRepository.findById(studentid);
		if(optStu.isPresent())
		{
			Student st = optStu.get();
			
			Optional<Course> optCou = cRepository.findById(courseid);
			Course course = optCou.get();
			st.getCourses().add(course);
			course.getStudents().add(st);
//			System.out.println(st.getCourses());
			sRepository.save(st);
			return "Student with id "+studentid+" added to course "+courseid+" "+course.getName();
		}
		else
		{
			throw new StudentException("Student not found with id: "+studentid);
		}
	}

	
	

}
