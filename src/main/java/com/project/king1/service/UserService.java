package com.project.king1.service;

import java.util.List;

import com.project.king1.model.User;

public interface UserService {
	//for get all users
	List<User> get();
	//for get specific user
	User get(int id);
	//for save or update user
	User save(User user);
	//for update or update user
	User update(User user);
	//for delete specific user
	void delete(int id);
}
