package com.Employee.EmployeeSpring.Exception;
import java.time.LocalTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(value= {ApiExceptions.class})
	public ResponseEntity<Object> handleApiRequestException(ApiExceptions E){                                                       
		ApiExceptionPojo aipexecp=new ApiExceptionPojo(E.getMessage(), HttpStatus.BAD_REQUEST, LocalTime.now());
		return new ResponseEntity<>(aipexecp,HttpStatus.BAD_REQUEST);
	}
}
