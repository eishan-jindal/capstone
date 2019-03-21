package com.xen.cap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xen.cap.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
