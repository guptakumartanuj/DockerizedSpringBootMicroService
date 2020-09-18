package com.dtechgeek.demo.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dtechgeek.demo.model.Account;
import com.dtechgeek.demo.services.AccountService;

@Controller
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping()
	public ResponseEntity<List<Account>> getAllAccounts() throws Exception {
		return ResponseEntity.ok().body(accountService.getAllAccounts());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") String id) throws Exception {
		Account account = accountService.getAccountById(id);
		return ResponseEntity.ok().body(account);
	}

	@PostMapping()
	public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) throws Exception {
		return ResponseEntity.ok(accountService.saveAccount(account));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value = "id") String id,
			@Valid @RequestBody Account account) throws Exception {
		Account updatedAccount = accountService.updateAccount(id, account);
		return ResponseEntity.ok(updatedAccount);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable(value = "id") String id) throws Exception {

		accountService.deleteAccount(id);
		return ResponseEntity.ok("Deleted");

	}
}
