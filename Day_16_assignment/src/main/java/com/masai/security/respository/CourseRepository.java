package com.masai.security.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.security.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	
}
