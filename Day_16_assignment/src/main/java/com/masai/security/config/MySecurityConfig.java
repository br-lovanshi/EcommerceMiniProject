package com.masai.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {
	
	//https://bcrypt-generator.com/
	
	//insert into admin (id,address, password, role, user_name, email) values (1001, 'Pune','$2a$12$whvmK7S0JHdyz8Nj3fiL7.etoy6xDTsgp22VF3Ki130XUvUzX6uoS', 'ADMIN', 'Tushar', 'tushar@gmail.com');
	//insert into student (id, address, password, role, user_name, email) values (1002, 'Mumbai','$2a$12$C8ckFE3e6QIoLAEc0o6s1OIXunqRdfxJvDPdw6NQejECJe6zyhZFC', 'STUDENT', 'student1', 'student1@gmail.com');


	/*@Bean
	public InMemoryUserDetailsManager userDetails() {
		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		//Admin password = "1111"
		//User Password = "2222"
		UserDetails admin = User.withUsername("admin").password("$2a$12$whvmK7S0JHdyz8Nj3fiL7.etoy6xDTsgp22VF3Ki130XUvUzX6uoS").authorities("ADMIN").build();
		INSERT INTO employee (id, user_name, email, address, password, role) values (1001, 'hari', 'hari@gmail.com', 'Gurgaon', '$2a$12$whvmK7S0JHdyz8Nj3fiL7.etoy6xDTsgp22VF3Ki130XUvUzX6uoS', 'ADMIN');
		INSERT INTO employee (id, user_name, email, address, password, role) values (1002, 'shyam', 'shyam@gmail.com', 'Delhi', '$2a$12$C8ckFE3e6QIoLAEc0o6s1OIXunqRdfxJvDPdw6NQejECJe6zyhZFC', 'USER');
		UserDetails user = User.withUsername("user").password("$2a$12$4C95HV4CaDGf.8fTojdAYu/zC8omkc6UI6UCXymwGJeFr6B8JEg0.").authorities("USER").build();
		//user password = 54321, Admin password = 123456	
		userDetailsService.createUser(admin);
		userDetailsService.createUser(user);
		return userDetails;
	}*/
	//UserDetailsService
	//UserDetails
	
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(
				(auth) -> auth.requestMatchers("/student/courses").authenticated()
				.requestMatchers("/admin/courses","/admin/courses/{courseid}","/admin/students/{courseid}","/admin/students","/admin/students/{studentid}").hasAuthority("ADMIN")
				.requestMatchers("/student/students").permitAll()
		).csrf().disable().httpBasic();
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder encodePassword() {
		//return NoOpPasswordEncoder.getInstance(); //Not recommended
		return new BCryptPasswordEncoder();
	}
}
