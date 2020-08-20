package vn.com.itqnu.onlinetest.service;

import java.util.List;

import vn.com.itqnu.onlinetest.entity.Account;
import vn.com.itqnu.onlinetest.model.AccountModel;

public interface AccountService {

	// login
	Account checkUsernameAndPassword(String username, String password);
	
	// create
	Account createAccount(AccountModel accountModel);

	// select
	List<Account> getAllAccount();

	Account getAccountById(Long idAccount);

	// update
	Account updateAccount(AccountModel accountModel);

	// delete
	void deleteAccount(Long idAccount);
}
