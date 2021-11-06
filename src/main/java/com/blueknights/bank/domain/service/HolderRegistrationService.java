package com.blueknights.bank.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blueknights.bank.domain.exception.HolderNotFoundException;
import com.blueknights.bank.domain.model.Account;
import com.blueknights.bank.domain.model.Holder;
import com.blueknights.bank.domain.repository.HolderRepository;

@Service
public class HolderRegistrationService {

	@Autowired
	private HolderRepository holderRepository;

	@Autowired
	private AccountRegistrationService accountRegistrationService;

	@Transactional
	public Holder save(Holder holder) {

		Holder currentHolder = holderRepository.save(holder);

		List<Account> accounts = holder.getAccounts();

		accounts.stream().map(account -> {
			account.setHolder(currentHolder);
			return account;
		}).forEach(accountRegistrationService::save);

		return holder;
	}

	public Holder fetchOrFail(Long holderId) {
		return holderRepository.findById(holderId).orElseThrow(() -> new HolderNotFoundException(holderId));
	}

}
