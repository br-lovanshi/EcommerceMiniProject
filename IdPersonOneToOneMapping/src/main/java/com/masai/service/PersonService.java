package com.masai.service;

import com.masai.model.Person;

public interface PersonService {


	public Person registerPerson(Person person) throws Exception;

	public Person remove(Integer id) throws Exception;
}
