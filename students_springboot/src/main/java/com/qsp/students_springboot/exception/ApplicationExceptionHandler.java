package com.qsp.students_springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.students_springboot.util.ResponseSturcture;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler
{
		@ExceptionHandler(IdNotFoundException.class)
		public ResponseEntity<ResponseSturcture<String>> idNotFoundExceptionHandler(IdNotFoundException exception)
		{
			ResponseSturcture<String> structure=new ResponseSturcture<>();
			
			structure.setMessage(exception.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData("Employee with Respective id is not found..");
			
			return new ResponseEntity<ResponseSturcture<String>>(structure,HttpStatus.NOT_FOUND );
		}
		
		@ExceptionHandler(EmailNotFoundException.class)
		public ResponseEntity<ResponseSturcture<String>> emailNotFoundExceptionHandler(EmailNotFoundException exception)
		{
			ResponseSturcture<String> structure=new ResponseSturcture<>();
			
			structure.setMessage(exception.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData("Employee with Respective id is not found..");
			
			return new ResponseEntity<ResponseSturcture<String>>(structure,HttpStatus.NOT_FOUND );
		}
		
		@ExceptionHandler(PhoneNotFoundException.class)
		public ResponseEntity<ResponseSturcture<String>> phoneNotFoundExceptionHandler(PhoneNotFoundException exception)
		{
			ResponseSturcture<String> structure=new ResponseSturcture<>();
			
			structure.setMessage(exception.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData("Employee with Respective id is not found..");
			
			return new ResponseEntity<ResponseSturcture<String>>(structure,HttpStatus.NOT_FOUND );
		}
		
		@ExceptionHandler(DataNotAvailable.class)
		public ResponseEntity<ResponseSturcture<String>> DataNotAvailableExceptionHandler(DataNotAvailable exception)
		{
			ResponseSturcture<String> structure=new ResponseSturcture<>();
			
			structure.setMessage(exception.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData("Employee with Respective id is not found..");
			
			return new ResponseEntity<ResponseSturcture<String>>(structure,HttpStatus.NOT_FOUND );
		}
}
