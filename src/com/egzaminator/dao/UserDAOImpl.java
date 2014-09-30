package com.egzaminator.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.egzaminator.entities.User;

@Repository
//Automatically starts transaction when method calls database operation and commit when method returns successfully
//@Transactional
public class UserDAOImpl {


	@Autowired
	private SessionFactory sf;
	
	public void test() {
		
		Session session = sf.openSession();

	     session.beginTransaction();
	     User user = new User();
	     user.setInfo("costam");
	     session.save(user);
	     //session.getTransaction().commit();
	}
	
	
	
	// GETTERS / SETTERS


	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sf = sessionfactory;
	}
	
}
