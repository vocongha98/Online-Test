package vn.com.itqnu.onlinetest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.itqnu.onlinetest.entity.Account;
import vn.com.itqnu.onlinetest.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping
	public List<Account> getAllAccount() {
		return accountService.getAllAccount();
	}
}
