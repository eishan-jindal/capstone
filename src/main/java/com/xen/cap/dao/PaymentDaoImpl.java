package com.xen.cap.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xen.cap.entity.Payment;

@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Payment savePayment(Payment payment) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(payment);
		return payment;
		
	}

}
