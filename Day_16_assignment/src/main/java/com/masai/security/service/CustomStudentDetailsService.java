//package com.masai.security.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.masai.security.entity.Admin;
//import com.masai.security.entity.SecurityAdmin;
//import com.masai.security.entity.SecurityStudent;
//import com.masai.security.entity.Student;
//import com.masai.security.respository.AdminRepository;
//import com.masai.security.respository.StudentRepository;
//
//@Service
//public class CustomStudentDetailsService implements UserDetailsService{
//
//	@Autowired
//	StudentRepository repository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		//Login to fetch the Employee from database
//		System.out.println("In loadUserByUSername");
//		Student student = repository.findByUserName(username);
//		if(student != null)
//			return new SecurityStudent(student);  //UserDetails object
//		else
//			throw new UsernameNotFoundException("User Does Not Exist..!");
//	}
//
//}
