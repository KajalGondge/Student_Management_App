package com.qsp.students_springboot.exception;

public class IdNotFoundException extends RuntimeException
{

	String message;

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
	// TODO Auto-generated method stub
	return message;
	}
}
