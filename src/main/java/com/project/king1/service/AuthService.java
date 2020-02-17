package com.project.king1.service;

import org.springframework.http.ResponseEntity;

import com.project.king1.model.ResponseModel;
import com.project.king1.model.User;

public interface AuthService {
	
	//for user login
	ResponseEntity<ResponseModel> login(User user);
	

}
