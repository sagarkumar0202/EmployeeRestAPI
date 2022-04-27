package org.employee.exception;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=EmptyResultDataAccessException.class)
	public ResponseEntity<String> EmptyResultDataAccessExceptionHandler()
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No/wrong employee id provided!!");
	}
	
	@ExceptionHandler(value=HttpMessageNotReadableException.class)
	public ResponseEntity<String> HttpMessageNotReadableExceptionHandler()
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request body is missing!!");
	}
	
	@ExceptionHandler(value=NoSuchElementException.class)
	public ResponseEntity<String> NoSuchElementExceptionHandler()
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("wrong employee id provided!!");
	}
	
	@ExceptionHandler(value=idNotFoundException.class)
	public ResponseEntity<String> idNotFoundExceptionHandler()
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee id does not exist!!");
	}
	
	
	@ExceptionHandler(value=Exception.class)
	public ResponseEntity<String> genericExceptionHandler()
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong!!");
	}

}
