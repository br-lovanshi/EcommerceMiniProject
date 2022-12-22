package com.masai.security.entity;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityStudent implements UserDetails{

	private static final long serialVersionUID = 1L;

	private Student student;
	
	
	public SecurityStudent(Student student) {
		this.student = student;
	}
	

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("in grantedAuthorities");
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(student.getRole());
		grantedAuthorities.add(grantedAuthority);
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		System.out.println("In student get password..!");
		return student.getPassword();
	}

	@Override
	public String getUsername() {
		System.out.println("In student get username");
		return student.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
