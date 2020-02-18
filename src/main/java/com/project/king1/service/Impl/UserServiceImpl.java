package com.project.king1.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.king1.dao.UserDAO;
import com.project.king1.model.User;
import com.project.king1.service.UserService;
import com.project.king1.utils.SendEmail;

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

	@Autowired
	private SendEmail mail;
	
//	@Transactional
	@Override
	public User save(User user) {
		User usr = userDao.save(user);
		if(usr != null) {
			String message = "Hello "+user.getName()+" ! Welcome to Java World";
			mail.sendEmail(message,"[From] Gateway java Corporation Head",user.getEmail());
			return user;
		}
		return null;
	}
	
	@Transactional
	@Override
	public User update(User user) {
		User usr = userDao.save(user);
		if(usr != null) {
			return user;
		}
		return null;
	}
	
	@Transactional
	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

}
