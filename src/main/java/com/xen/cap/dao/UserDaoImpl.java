package com.xen.cap.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xen.cap.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public User getUserByUsername(String username) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("select u from User u where u.username = :username");
						theQuery.setParameter("username", username);
		
		User user = (User) theQuery.uniqueResult();
		if(user==null) return null;
		return user;
	}
	
	public User getUserByCredentials(String username, String password) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("select u from User u where u.username = :username and u.password = :password");
						theQuery.setParameter("username", username);
						theQuery.setParameter("password", password);
		
		User user = (User) theQuery.uniqueResult();
		if(user==null) return null;
		return user;
	}
	
	public void saveUser(User user) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(user);
	}
	
	public void saveUser(long id, String balance, String role, String password, String username) {
		// get current hibernate session
		Session currentSession = sessionFactory.openSession();
		
		User u = new User();
		u.setId(id);
		u.setBalance(balance);
		u.setPassword(password);
		u.setRole(role);
		u.setUsername(username);
		
		Transaction tx = currentSession.beginTransaction();
		currentSession.update(u);
		tx.commit();
		currentSession.close();
		/*
		Query theQuery = 
				currentSession.createQuery("update User u set u.balance = :newBalance where u.username = :username");
						theQuery.setParameter("username", userToBeUpdated.getUsername());
						theQuery.setParameter("newBalance", userToBeUpdated.getBalance());
		theQuery.executeUpdate();*/
	}

}
