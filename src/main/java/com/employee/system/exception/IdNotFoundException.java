package com.employee.system.exception;

public class IdNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 String message;
	 public IdNotFoundException(String message) {
	        super(message);
	
		
	}
}
