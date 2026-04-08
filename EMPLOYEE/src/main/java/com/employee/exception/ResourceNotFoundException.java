package com.employee.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus httpStatus;
	
	public ResourceNotFoundException(String message){
		super();
		this.message =message;
		this.httpStatus=HttpStatus.NOT_FOUND;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	
	
}
