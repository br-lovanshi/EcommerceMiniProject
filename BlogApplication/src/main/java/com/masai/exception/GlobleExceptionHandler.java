package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(PostException.class)
	public ResponseEntity<MyErrorDetail> postExceptionHandler(PostException
			pe,WebRequest req){
		
		MyErrorDetail err = new MyErrorDetail();
		err.setLocalTime(LocalDateTime.now());
		err.setMassege(pe.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
		
	}
	@ExceptionHandler(CommentException.class)
	public ResponseEntity<MyErrorDetail> commentExceptionHandler(CommentException
			pe,WebRequest req){
		
		MyErrorDetail err = new MyErrorDetail();
		err.setLocalTime(LocalDateTime.now());
		err.setMassege(pe.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetail> ExceptionHandler(Exception se, WebRequest req) {
		
		MyErrorDetail err= new MyErrorDetail();
		err.setLocalTime(LocalDateTime.now());
		err.setMassege(se.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<MyErrorDetail>(err,HttpStatus.BAD_REQUEST);
		
	}
	
}
