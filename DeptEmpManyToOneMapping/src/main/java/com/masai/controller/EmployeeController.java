package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Employee;
import com.masai.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService eService;
	
	@PostMapping("/")
	public ResponseEntity<Employee> employeeHandler(@RequestBody Employee emp) throws Exception{
		
		Employee addEmp = eService.addEmployee(emp);
		
		return new ResponseEntity<Employee>(addEmp,HttpStatus.CREATED);
	}
	
	
}
