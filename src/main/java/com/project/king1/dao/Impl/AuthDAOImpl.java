package com.project.king1.dao.Impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.king1.dao.AuthDAO;
import com.project.king1.model.User;

@Repository
public class AuthDAOImpl implements AuthDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public User login(User user) {
		//create currentSession object
		Session currentSession = entityManager.unwrap(Session.class);
		User affectedUser;
		try {
			affectedUser = currentSession.createQuery("from User where email= :email and password= :password",User.class).setParameter("email", user.getEmail()).setParameter("password", user.getPassword()).getSingleResult();
		}catch (NoResultException ex) {
			System.out.println("no result found");
			affectedUser = null;
		}
		return affectedUser;
	}
}
