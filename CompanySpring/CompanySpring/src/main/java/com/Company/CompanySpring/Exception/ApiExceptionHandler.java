package com.Company.CompanySpring.Exception;

import java.time.LocalTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(value= {ApiExceptions.class})
	public ResponseEntity<String> handleApiRequestException(ApiExceptions E){                                                       
		ApiExceptionPojo aipexecp=new ApiExceptionPojo(E.getMessage(), HttpStatus.BAD_GATEWAY, LocalTime.now());
		return new ResponseEntity<String>("bad tj",HttpStatus.BAD_REQUEST);
	}
}
