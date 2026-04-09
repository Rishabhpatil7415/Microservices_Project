package com.Address.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleresourcenotfoundexception(ResourceNotFoundException ex){
		ErrorResponse error =new ErrorResponse(ex.getMessage(),ex.getHttpStatus());
		return new ResponseEntity<>(error,ex.getHttpStatus());
		
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handlBadReqestException(BadRequestException ex){
		ErrorResponse error =new ErrorResponse(ex.getMessage(),ex.getHttpstatus());
		return new ResponseEntity<>(error,ex.getHttpstatus());	
	}
}
