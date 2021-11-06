package com.blueknights.bank.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueknights.bank.api.model.dto.input.AccountInputDTO;
import com.blueknights.bank.domain.model.Account;

@Component
public class AccountInputDTODisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Account toDomainObject(AccountInputDTO accountInput) {

		return modelMapper.map(accountInput, Account.class);
	}

	public void copyToDomainObject(AccountInputDTO accountInput, Account account) {
		modelMapper.map(accountInput, account);
	}
}
