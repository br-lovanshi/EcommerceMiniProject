package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Department;
import com.masai.entity.Employee;
import com.masai.repositrory.DepartmentRepo;
import com.masai.repositrory.EmployeeRepo;

@Service

public class EmployeeServiceImpl  implements EmployeeService{

	@Autowired
	private EmployeeRepo eDao;
	
	@Autowired
	private DepartmentRepo dDao;
	
	
	@Override
	public Employee addEmployee(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		
		Optional<Department> opt = dDao.findById(emp.getDepartment().getDepId());
		
		if(opt.isPresent()) {
			
			return eDao.save(emp);
			
		}
		throw new Exception("department is Not present of ID -> " + emp.getDepartment().getDepId());
	}

}
