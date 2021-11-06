package com.blueknights.bank.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueknights.bank.api.model.dto.output.AccountOutputDTO;
import com.blueknights.bank.domain.model.Account;

@Component
public class AccountOutputDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public AccountOutputDTO toDTO(Account account) {
		return modelMapper.map(account, AccountOutputDTO.class);
	}

	public List<AccountOutputDTO> toCollectionDTO(Collection<Account> accounts) {
		return accounts.stream().map(this::toDTO).collect(Collectors.toList());
	}
}
