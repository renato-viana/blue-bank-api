package com.blueknights.bank.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blueknights.bank.domain.exception.HolderNotFoundException;
import com.blueknights.bank.domain.model.Holder;
import com.blueknights.bank.domain.repository.HolderRepository;

@Service
public class HolderRegistrationService {

	@Autowired
	private HolderRepository holderRepository;

	@Transactional
	public Holder save(Holder holder) {
		return holderRepository.save(holder);
	}

	public Holder fetchOrFail(Long holderId) {
		return holderRepository.findById(holderId).orElseThrow(() -> new HolderNotFoundException(holderId));
	}

}
