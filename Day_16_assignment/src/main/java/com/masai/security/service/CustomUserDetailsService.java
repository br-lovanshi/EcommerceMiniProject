package com.masai.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.security.entity.Admin;
import com.masai.security.entity.SecurityAdmin;
import com.masai.security.entity.SecurityStudent;
import com.masai.security.entity.Student;
import com.masai.security.respository.AdminRepository;
import com.masai.security.respository.StudentRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	AdminRepository repository1;
	
	@Autowired
	StudentRepository repository2;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Login to fetch the Employee from database
		System.out.println("In loadUserByUSername");
		Admin admin = repository1.findByUserName(username);
		Student student = repository2.findByUserName(username);
		
		//to work this..please dont add same usernames for both admin and student
		
		if(admin != null)
		{
			return new SecurityAdmin(admin);  //UserDetails object
		}
		else if(student != null)
		{
			return new SecurityStudent(student);
		}
		else
		{
			throw new UsernameNotFoundException("User Does Not Exist..!");
		}
	}

}
