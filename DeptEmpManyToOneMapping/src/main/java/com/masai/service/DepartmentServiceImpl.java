package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Department;
import com.masai.repositrory.DepartmentRepo;

@Service
public class DepartmentServiceImpl  implements DepartmentService{

	
	@Autowired
	private DepartmentRepo dDao;
	
	@Override
	public Department registerDepartment(Department dept) throws Exception {
		// TODO Auto-generated method stub
		return dDao.save(dept);
	}

}
