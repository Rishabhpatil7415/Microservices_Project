package com.auth.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException{


	private String message;
	private HttpStatus httpstatus;
	
	public BadRequestException(String message) {
		super();
		this.message =message;
		this.httpstatus =HttpStatus.BAD_GATEWAY;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	
	
}
