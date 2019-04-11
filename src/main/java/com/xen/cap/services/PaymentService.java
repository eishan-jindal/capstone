package com.xen.cap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xen.cap.converter.PaymentConverter;
import com.xen.cap.dao.PaymentDao;
import com.xen.cap.dto.PaymentDto;
import com.xen.cap.entity.Payment;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentService {
	
	@Autowired
	private PaymentDao paymentDao;

	
	public PaymentDto savePayment(Payment payment) {
		
		return PaymentConverter.convertToDto(paymentDao.savePayment(payment));
	}
	
	public Payment createNewPayment(String merchant, String customer, String money) {
		
		Payment payment = new Payment();
		payment.setCustomer(customer);
		payment.setMerchant(merchant);
		payment.setMoney(money);
		
		return payment;
	}
	
}
