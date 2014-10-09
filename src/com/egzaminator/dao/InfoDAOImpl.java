package com.egzaminator.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.egzaminator.entities.Info;

@Repository
//Automatically starts transaction when method calls database operation and commit when method returns successfully
//@Transactional
public class InfoDAOImpl implements Serializable {


	//@Autowired
	//private SessionFactory sf;
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void test() {
		
		/*Session session = sf.openSession();

	     session.beginTransaction();
	     User user = new User();
	     user.setInfo("costam");
	     session.save(user);
	     session.getTransaction().commit();*/
		
		Info user = new Info();
		user.setInfo("costam");
		em.persist(user);
	}
	
	// GETTERS / SETTERS


	//public void setSessionfactory(SessionFactory sessionfactory) {
	//	this.sf = sessionfactory;
	//}
	

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}
