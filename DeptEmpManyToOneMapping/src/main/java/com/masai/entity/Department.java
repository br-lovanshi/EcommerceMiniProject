package com.masai.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer depId;
	private String depName;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "department")
	private List<Employee> employees;
	
	
	public Department() {
		// TODO Auto-generated constructor stub
	}


	public Integer getDepId() {
		return depId;
	}


	public void setDepId(Integer depId) {
		this.depId = depId;
	}


	public String getDepName() {
		return depName;
	}


	public void setDepName(String depName) {
		this.depName = depName;
	}


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	public Department(Integer depId, String depName, List<Employee> employees) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + ", employees=" + employees + "]";
	}
	
	
	
	
	

}
