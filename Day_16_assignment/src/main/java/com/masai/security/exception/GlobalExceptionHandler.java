package com.masai.security.exception;

import java.time.LocalDate;

import java.time.LocalDateTime;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;



@ControllerAdvice
public class GlobalExceptionHandler {
	

	
	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ErrorMessage> myExceptionHandler(StudentException ex, WebRequest request)
	{
		ErrorMessage msg = new ErrorMessage(ex.getMessage(), request.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<ErrorMessage>(msg, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CourseException.class)
	public ResponseEntity<ErrorMessage> myExceptionHandler2(CourseException ex, WebRequest request)
	{
		ErrorMessage msg = new ErrorMessage(ex.getMessage(), request.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<ErrorMessage>(msg, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> myExceptionHandler3(Exception ex, WebRequest request)
	{
		ErrorMessage msg = new ErrorMessage(ex.getMessage(), request.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<ErrorMessage>(msg, HttpStatus.BAD_REQUEST);
	}
	
	
	
//	Method argument not valid exception
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> myexceptionHandler4(MethodArgumentNotValidException mp){
		
		ErrorMessage err= new ErrorMessage();
		err.setErrorTime(LocalDateTime.now());
		err.setMsg("Validation error");
		err.setDescription(mp.getBindingResult().getFieldError().getDefaultMessage());
		
		
		
		return new ResponseEntity<ErrorMessage>(err, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
	}
	

//	No handler found exception
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorMessage> mynotFoundHandler5(NoHandlerFoundException nfe,WebRequest req)  {
			
	
		ErrorMessage err=new ErrorMessage(nfe.getMessage(), req.getDescription(false),LocalDateTime.now());
	
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
					
	}
	

	

}
