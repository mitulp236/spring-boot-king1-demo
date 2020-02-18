package com.project.king1.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.king1.dao.AuthDAO;
import com.project.king1.model.ResponseModel;
import com.project.king1.model.User;
import com.project.king1.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private AuthDAO authDAO;
	
	@Override
	@Transactional
	public ResponseEntity<ResponseModel> login(User user) {
		User affectedUser = authDAO.login(user);
		ResponseModel res = new ResponseModel();
		if(affectedUser != null) {
			if(affectedUser.getPassword().equals(user.getPassword())) {
				//success
				res.setMessage("Login Successfully ");
				return ResponseEntity.status(HttpStatus.OK).body(res);
			}
		}
		//wrong email or password
		res.setMessage("Wrong email or password !");
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(res);
	}
	
	
}
