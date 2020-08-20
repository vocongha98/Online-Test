package vn.com.itqnu.onlinetest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.com.itqnu.onlinetest.entity.Account;
import vn.com.itqnu.onlinetest.model.AccountModel;
import vn.com.itqnu.onlinetest.repository.AccountRepository;
import vn.com.itqnu.onlinetest.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public Account checkUsernameAndPassword(String username, String password) {
		Account account = accountRepository.findByUsername(username);

		if (username == null || username.trim().length() == 0) {
			throw new RuntimeException("Username is required!");
		}

		if (password == null || password.trim().length() == 0) {
			throw new RuntimeException("Password is required!");
		}

		if (account == null) {
			throw new RuntimeException("Username or password invalid!");
		}

		if (!account.getPassword().equals(password)) {
			throw new RuntimeException("Username or password invalid!");
		}

		return account;
	}

	@Override
	public AccountModel createAccount(AccountModel accountModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(Long idAccount) {
		Optional<Account> optional = accountRepository.findById(idAccount);
		if (optional != null && optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public AccountModel updateAccount(AccountModel accountModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(Long idAccount) {
		Account account = getAccountById(idAccount);

		if (account == null) {
			throw new RuntimeException("Account not exist!");
		}

		accountRepository.delete(account);
	}

}
