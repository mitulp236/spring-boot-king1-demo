package com.project.king1.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.king1.model.ResponseModel;
import com.project.king1.model.User;
import com.project.king1.service.AuthService;

@RestController
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private AuthService authservice;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseModel> login(@RequestBody User user) {
		return authservice.login(user);
	}
}
