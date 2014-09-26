package com.egzaminator.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.egzaminator.HibernateUtil;
import com.egzaminator.entities.User;

@Repository
public class UserDAOImpl {


	@Autowired
	private SessionFactory sf;
	
	
	public void test() {
		
		Session session = sf.getCurrentSession();

	     session.beginTransaction();
	     User user = new User();
	     user.setInfo("costam");
	     session.save(user);
	     
	     session.getTransaction().commit();
	     
	}
	
	
	
	// GETTERS / SETTERS


	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sf = sessionfactory;
	}
	
}
