package com.qsp.students_springboot.exception;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.students_springboot.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler
{
		@ExceptionHandler(IdNotFoundException.class)
		public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFoundException exception)
		{
			ResponseStructure<String> structure=new ResponseStructure<>();
			
			structure.setMessage(exception.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData("Employee with Respective id is not found..");
			
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND );
		}
		
		@ExceptionHandler(EmailNotFoundException.class)
		public ResponseEntity<ResponseStructure<String>> emailNotFoundExceptionHandler(EmailNotFoundException exception)
		{
			ResponseStructure<String> structure=new ResponseStructure<>();
			
			structure.setMessage(exception.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData("Employee with Respective email is not found..");
			
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND );
		}
		
		@ExceptionHandler(PhoneNotFoundException.class)
		public ResponseEntity<ResponseStructure<String>> phoneNotFoundExceptionHandler(PhoneNotFoundException exception)
		{
			ResponseStructure<String> structure=new ResponseStructure<>();
			
			structure.setMessage(exception.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData("Employee with Respective Phone is not found..");
			
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND );
		}
		
		@ExceptionHandler(DataNotAvailable.class)
		public ResponseEntity<ResponseStructure<String>> DataNotAvailableExceptionHandler(DataNotAvailable exception)
		{
			ResponseStructure<String> structure=new ResponseStructure<>();
			
			structure.setMessage(exception.getMessage());
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData("Employee with Respective data is not available..");
			
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND );
		}
}
