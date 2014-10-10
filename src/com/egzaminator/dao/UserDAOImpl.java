package com.egzaminator.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.egzaminator.entities.User;

@Repository
public class UserDAOImpl implements UserDAO, Serializable {

	
	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional
	public void addUser(Object name, Object surname) {
		
		User user = new User();
		user.setName((String)name);
		user.setSurname((String)surname);
		em.persist(user);
	}
	
	
	// GETTERS / SETTERS

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
