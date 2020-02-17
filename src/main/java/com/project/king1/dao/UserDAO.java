package com.project.king1.dao;

import java.util.List;

import com.project.king1.model.User;

public interface UserDAO {

	//for get all users
	 List<User> get();
	 //for get specific user
	 User get(int id);
	 //for add or update user
	 void save(User user);
	 //for delete the user
	 void delete(int id);
}
