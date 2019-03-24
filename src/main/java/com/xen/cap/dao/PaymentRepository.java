package com.xen.cap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xen.cap.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
