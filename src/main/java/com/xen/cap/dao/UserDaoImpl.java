package com.xen.cap.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xen.cap.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public User getUserById(long userID) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		User user = currentSession.get(User.class, userID);
		
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

}
