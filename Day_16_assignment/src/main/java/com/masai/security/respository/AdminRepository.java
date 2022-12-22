package com.masai.security.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.masai.security.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	public Admin findByUserName(String username);
}
