package com.masai.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	private String courseName;
	private Integer fee;
	private String desc;
	
	
	@ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
	private Set<Student> students = new HashSet<>();
	
	
	 public Course() {
		 
	}


	public Course(Integer courseId, String courseName, Integer fee, String desc, Set<Student> students) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.fee = fee;
		this.desc = desc;
		this.students = students;
	}


	public Integer getCourseId() {
		return courseId;
	}


	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public Integer getFee() {
		return fee;
	}


	public void setFee(Integer fee) {
		this.fee = fee;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public Set<Student> getStudents() {
		return students;
	}


	public void setStudents(Set<Student> students) {
		this.students = students;
	}


	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", fee=" + fee + ", desc=" + desc
				+ ", students=" + students + "]";
	}
	 
	 
	
	
}
