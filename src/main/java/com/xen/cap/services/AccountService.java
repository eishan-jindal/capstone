package com.xen.cap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xen.cap.dao.AccountRepository;
import com.xen.cap.entity.Account;





@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	
	public List<Account> findAll(){
		return accountRepository.findAll();
	}
	
	public void save(Account account) {
		accountRepository.save(account);
	}
}
