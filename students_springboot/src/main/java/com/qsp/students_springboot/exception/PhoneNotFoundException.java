package com.qsp.students_springboot.exception;

public class PhoneNotFoundException extends RuntimeException
{
	String message;

	public PhoneNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String getMessage() {
	// TODO Auto-generated method stub
	return message;
	}

}
