package com.dtechgeek.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dtechgeek.demo.model.Account;

@Service
public interface AccountService {

	public List<Account> getAllAccounts() throws Exception;

	public Account getAccountById(String id) throws NumberFormatException, Exception;

	public Account saveAccount(Account Account) throws Exception;

	public Account updateAccount(String id, Account updatedAccount) throws NumberFormatException, Exception;

	public void deleteAccount(String id) throws NumberFormatException, Exception;
}