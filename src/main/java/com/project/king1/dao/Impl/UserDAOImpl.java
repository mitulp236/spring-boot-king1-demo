package com.project.king1.dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.king1.dao.UserDAO;
import com.project.king1.model.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<User> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> query = currentSession.createQuery("from User",User.class);
		List<User> list = query.getResultList();
		return list;
	}

	@Override
	public User get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(User.class, id);
	}

	@Override
	public User save(User user) {
		if(user != null) {
			Session currentSession = entityManager.unwrap(Session.class);
			currentSession.saveOrUpdate(user);
			return user;
		}
		return null;
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		User affectedUser = currentSession.get(User.class, id);
		currentSession.remove(affectedUser);		
	}

}
