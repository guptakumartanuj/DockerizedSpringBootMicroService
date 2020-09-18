package com.dtechgeek.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dtechgeek.demo.model.Account;
import com.dtechgeek.demo.repository.AccountRepository;
import com.dtechgeek.demo.services.AccountService;

@Component
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository AccountRepository;

	@Override
	public List<Account> getAllAccounts() throws Exception {
		return AccountRepository.findAll();

	}

	@Override
	public Account getAccountById(String id) throws NumberFormatException, Exception {
		Account Account = AccountRepository.findById(Integer.parseInt(id))
				.orElseThrow(() -> new Exception("Account not found :: " + id));
		return Account;
	}

	@Override
	public Account saveAccount(Account Account) throws Exception {
		return AccountRepository.save(Account);
	}

	@Override
	public Account updateAccount(String id, Account updatedAccount) throws NumberFormatException, Exception {
		Account Account = AccountRepository.findById(Integer.parseInt(id))
				.orElseThrow(() -> new Exception("Account not found :: " + id));

		Account.setName(updatedAccount.getName());
		return AccountRepository.save(Account);
	}

	@Override
	public void deleteAccount(String id) throws NumberFormatException, Exception {

		Account Account = AccountRepository.findById(Integer.parseInt(id))
				.orElseThrow(() -> new Exception("Account not found :: " + id));

		AccountRepository.delete(Account);
	}
}