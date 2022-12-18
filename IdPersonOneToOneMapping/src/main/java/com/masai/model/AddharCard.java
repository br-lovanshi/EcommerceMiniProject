package com.masai.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AddharCard {

	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer aId;
	private String aHodlerName;
	
	@OneToOne
	@JoinColumn(name = "personId")
	private Person person;
	
	public AddharCard() {
		// TODO Auto-generated constructor stub
	}
	
	

	public AddharCard(Integer aId, String aHodlerName, Person person) {
		super();
		this.aId = aId;
		this.aHodlerName = aHodlerName;
		this.person = person;
	}



	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public String getaHodlerName() {
		return aHodlerName;
	}

	public void setaHodlerName(String aHodlerName) {
		this.aHodlerName = aHodlerName;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "AddharCard [aId=" + aId + ", aHodlerName=" + aHodlerName + ", person=" + person + "]";
	}
	
	
	
	
}
