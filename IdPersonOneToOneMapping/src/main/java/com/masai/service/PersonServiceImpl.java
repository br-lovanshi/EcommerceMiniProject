package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.model.Person;
import com.masai.repo.PersonRepo;

@Service
public class PersonServiceImpl implements PersonService{

	
	@Autowired
	private PersonRepo pRepo;
	

	@Override
	public Person registerPerson(Person person) throws Exception {
		// TODO Auto-generated method stub
		return  pRepo.save(person);
	}


	@Override
	public Person remove(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Optional<Person> opt = pRepo.findById(id);
		if(opt.isPresent()) {
			
			Person remove = opt.get();
			pRepo.delete(remove);
			
			return remove;
		}else
			throw new Exception("No Aid found of ID " +id);
	}
	
	
}
