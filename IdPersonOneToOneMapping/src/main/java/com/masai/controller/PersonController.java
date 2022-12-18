package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Person;
import com.masai.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService pService;
	
	
	@PostMapping("/person")
	public ResponseEntity<Person> addPerson(@RequestBody Person p) throws Exception{
		
		Person addPerson1 = pService.registerPerson(p);
		
		return new ResponseEntity<Person>(addPerson1,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/removeById/{id}")
	public ResponseEntity<Person> removeById(@PathVariable ("id") Integer id) throws Exception{
		Person remove = pService.remove(id);
		return new ResponseEntity<Person>(remove,HttpStatus.OK);
	}

}
