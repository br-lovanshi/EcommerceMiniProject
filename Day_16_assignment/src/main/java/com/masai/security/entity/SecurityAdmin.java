package com.masai.security.entity;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityAdmin implements UserDetails{

	private static final long serialVersionUID = 1L;

	private Admin admin;
	
	
	public SecurityAdmin(Admin admin) {
		this.admin = admin;
	}
	

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("in grantedAuthorities");
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(admin.getRole());
		grantedAuthorities.add(grantedAuthority);
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		System.out.println("In admin get password..!");
		return admin.getPassword();
	}

	@Override
	public String getUsername() {
		System.out.println("In admin get username");
		return admin.getUserName();
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
