package com.Company.CompanySpring.Exception;

import java.time.LocalTime;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiExceptionPojo {
	
	String messgae;
	HttpStatus httpStatus;
	LocalTime time;
	public String getMessgae() {
		return messgae;
	}
	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public ApiExceptionPojo(String messgae,  HttpStatus httpStatus, LocalTime time) {
		super();
		this.messgae = messgae;
		this.httpStatus = httpStatus;
		this.time = time;
	}
	
}
