package com.masai.security.respository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.security.entity.Course;
import com.masai.security.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	public Student findByUserName(String username);
	
	
	public List<Student> findByCourses(Course course);
}
