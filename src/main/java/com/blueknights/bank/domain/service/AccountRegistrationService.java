package com.blueknights.bank.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blueknights.bank.domain.model.Holder;
import com.blueknights.bank.domain.repository.AccountHolderRepository;

@Service
public class AccountRegistrationService {

	@Autowired
	private AccountHolderRepository accountHolderRepository;

	@Transactional
	public Holder salvar(Holder holder) {
		return accountHolderRepository.save(holder);
	}

}
