package com.xen.cap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xen.cap.entity.Account;
import com.xen.cap.services.AccountService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String userHome(Model theModel) {
		theModel.addAttribute("theDate", new java.util.Date());
		return "home";
	}

	@RequestMapping("/list")
	public String listUsers(Model theModel) {
		List<Account> accounts = accountService.findAll();
		if (accounts == null)
			return "home";
		theModel.addAttribute("accounts", accounts);
		return "listAccounts";
	}

	@RequestMapping("/form")
	public String saveUser(Model theModel) {
		Account newAccount = new Account();
		theModel.addAttribute("account", newAccount);
		return "NewUser";
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public String accountSave(@ModelAttribute("account") Account account) {

		accountService.save(account);
		return "redirect:/user/list";
	}

}
