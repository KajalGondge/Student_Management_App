package com.qsp.students_springboot.exception;

public class DataNotAvailable extends RuntimeException
{

		String message;

		public DataNotAvailable(String message) {
			super();
			this.message = message;
		}
		
		@Override
		public String getMessage() {
		// TODO Auto-generated method stub
		return message;
		}
}
