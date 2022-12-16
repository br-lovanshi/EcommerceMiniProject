package com.masai.repositrory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo  extends JpaRepository<com.masai.entity.Department,Integer>{

}
