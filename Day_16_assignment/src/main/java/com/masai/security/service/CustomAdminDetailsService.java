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
//import com.masai.security.respository.AdminRepository;
//
//@Service
//public class CustomAdminDetailsService implements UserDetailsService{
//
//	@Autowired
//	AdminRepository repository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		//Login to fetch the Employee from database
//		System.out.println("In loadUserByUSername");
//		Admin admin = repository.findByUserName(username);
//		if(admin != null)
//			return new SecurityAdmin(admin);  //UserDetails object
//		else
//			throw new UsernameNotFoundException("User Does Not Exist..!");
//	}
//
//}
