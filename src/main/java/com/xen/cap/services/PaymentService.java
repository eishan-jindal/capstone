package com.xen.cap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xen.cap.dao.PaymentRepository;
import com.xen.cap.entity.Payment;





@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	public List<Payment> findAll(){
		return paymentRepository.findAll();
	}
	
	public void save(Payment payment) {
		paymentRepository.save(payment);
	}
}
