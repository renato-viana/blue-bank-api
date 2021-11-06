package com.blueknights.bank.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blueknights.bank.domain.exception.AccountNotFoundException;
import com.blueknights.bank.domain.model.Account;
import com.blueknights.bank.domain.repository.AccountRepository;

@Service
public class AccountRegistrationService {

	@Autowired
	private AccountRepository accountRepository;

	@Transactional
	public Account save(Account account) {
		return accountRepository.save(account);
	}

	public Account fetchOrFail(Long accountId) {
		return accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException(accountId));
	}

}
