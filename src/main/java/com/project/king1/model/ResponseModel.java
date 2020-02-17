package com.project.king1.model;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResponseModel {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
