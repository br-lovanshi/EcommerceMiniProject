package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.AddharCard;
import com.masai.model.Person;
import com.masai.service.AddharRepo;

import io.swagger.models.Response;

@RestController
public class Main {

	@Autowired
	 private AddharRepo aRepo;
	
	
	@GetMapping("/walcom")
	public String walcome() {
		return "Walcome to Brajesh Lovanshi MINI PROJECT";
	}
	
	
	@PostMapping("/addhar")
	public ResponseEntity<AddharCard> addharCardHandler(@RequestBody AddharCard aIds) throws Exception{
		AddharCard aid = aRepo.registerAddhhar(aIds);
		
		return new ResponseEntity<AddharCard>(aid,HttpStatus.CREATED);
	}
	
	@GetMapping("/IdByName/{name}")
	public ResponseEntity<AddharCard> getByName(@PathVariable ("name") Integer name) throws Exception{
		
		AddharCard aid = aRepo.getByName(name);

		return new ResponseEntity<AddharCard>(aid,HttpStatus.ACCEPTED);

	}
	
	@GetMapping("/getAllAddhar")
	public ResponseEntity<List<AddharCard>> getAll() throws Exception{
		
		List<AddharCard> aid = aRepo.listOfId();

		return new ResponseEntity<List<AddharCard>>(aid,HttpStatus.ACCEPTED);

	}
	
	@PostMapping("/update")
	public ResponseEntity<AddharCard> updateId(@RequestBody AddharCard name) throws Exception{
		
		AddharCard aid = aRepo.updateByid(name);

		return new ResponseEntity<AddharCard>(aid,HttpStatus.ACCEPTED);

	}
	
	
}
