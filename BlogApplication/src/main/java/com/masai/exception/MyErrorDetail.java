package com.masai.exception;

import java.time.LocalDateTime;

public class MyErrorDetail {
	
	private LocalDateTime localTime;
	private String massege;
	private String description;
	
	public MyErrorDetail() {
		// TODO Auto-generated constructor stub
	}

	public LocalDateTime getLocalTime() {
		return localTime;
	}

	public void setLocalTime(LocalDateTime localTime) {
		this.localTime = localTime;
	}

	public String getMassege() {
		return massege;
	}

	public void setMassege(String massege) {
		this.massege = massege;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MyErrorDetail(LocalDateTime localTime, String massege, String description) {
		super();
		this.localTime = localTime;
		this.massege = massege;
		this.description = description;
	}

	@Override
	public String toString() {
		return "MyErrorDetail [localTime=" + localTime + ", massege=" + massege + ", description=" + description + "]";
	}
	
	

}
