package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Department;
import com.masai.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentService dService;
	
	@GetMapping("/walcome")
	public String walcome() {
		return "walcome to BRAJESH LOVANSHI Rest API";
	}
	
	@PostMapping("/")
	public ResponseEntity<Department> addDepartment(@RequestBody Department dept) throws Exception{
		
		Department addDept = dService.registerDepartment(dept);
		
		return new ResponseEntity<Department>(addDept,HttpStatus.CREATED);
	}

}
