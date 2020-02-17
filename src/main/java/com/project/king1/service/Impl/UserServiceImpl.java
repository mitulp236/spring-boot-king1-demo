package com.project.king1.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.king1.dao.UserDAO;
import com.project.king1.model.User;
import com.project.king1.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDao;
	
	@Transactional
	@Override
	public List<User> get() {
		return userDao.get();
	}

	@Transactional
	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Transactional
	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Transactional
	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

}
