package vn.com.itqnu.onlinetest.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.com.itqnu.onlinetest.entity.Account;
import vn.com.itqnu.onlinetest.repository.AccountRepository;
import vn.com.itqnu.onlinetest.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

}
