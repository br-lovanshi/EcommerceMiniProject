package com.masai.security.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorMessage {
	
	private String msg;
	private String description;
	private LocalDateTime errorTime;
	
	
	public ErrorMessage()
	{
		
	}




	public ErrorMessage(String msg, String description, LocalDateTime errorTime) {
		super();
		this.msg = msg;
		this.description = description;
		this.errorTime = errorTime;
	}




	public String getMsg() {
		return msg;
	}




	public void setMsg(String msg) {
		this.msg = msg;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public LocalDateTime getErrorTime() {
		return errorTime;
	}




	public void setErrorTime(LocalDateTime errorTime) {
		this.errorTime = errorTime;
	}




	@Override
	public String toString() {
		return "ErrorMessage [msg=" + msg + ", description=" + description + ", errorTime=" + errorTime + "]";
	}



	
	

}
