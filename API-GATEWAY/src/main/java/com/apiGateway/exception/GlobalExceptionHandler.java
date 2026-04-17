package com.apiGateway.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handlBadReqestException(BadRequestException ex){
		ErrorResponse error =new ErrorResponse(ex.getMessage(),ex.getHttpstatus());
		return new ResponseEntity<>(error,ex.getHttpstatus());	
	}
}
