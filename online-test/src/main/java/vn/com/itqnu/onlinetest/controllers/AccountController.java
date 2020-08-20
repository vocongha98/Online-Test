package vn.com.itqnu.onlinetest.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		try {
			return ResponseEntity.ok(accountService.checkUsernameAndPassword(username, password));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@GetMapping
	public List<Account> getAllAccount() {
		return accountService.getAllAccount();
	}

	@GetMapping("/{id}")
	public Account getAccountById(@PathVariable(name = "id") Long idAccount) {
		return accountService.getAccountById(idAccount);
	}

	@DeleteMapping("/{id}")
	public String deleteAccountById(@PathVariable(name = "id") Long idAccount) {
		try {
			accountService.deleteAccount(idAccount);
			return "Delete success!";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
