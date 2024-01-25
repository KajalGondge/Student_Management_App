package com.qsp.students_springboot.exception;

public class EmailNotFoundException extends RuntimeException
{

	String message;

	public EmailNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
	// TODO Auto-generated method stub
	return message;
	}
}
