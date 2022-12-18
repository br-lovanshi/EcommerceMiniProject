package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

}
