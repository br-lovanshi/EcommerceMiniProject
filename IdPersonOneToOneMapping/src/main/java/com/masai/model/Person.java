package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer age;
	
	@JsonIgnore
	@OneToOne(mappedBy = "person")
	private AddharCard addharCard;

	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(Integer id, String name, Integer age, AddharCard addharCard) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.addharCard = addharCard;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public AddharCard getAddharCard() {
		return addharCard;
	}

	public void setAddharCard(AddharCard addharCard) {
		this.addharCard = addharCard;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", addharCard=" + addharCard + "]";
	}
	
	
	
}
