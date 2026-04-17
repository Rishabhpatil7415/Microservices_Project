package com.apiGateway.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException{


	private String message;
	private HttpStatus httpstatus;
	
	public BadRequestException(String message, HttpStatus unauthorized) {
		super();
		this.message =message;
		this.httpstatus =unauthorized;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	
	
}
