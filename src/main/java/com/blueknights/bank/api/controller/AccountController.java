package com.blueknights.bank.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueknights.bank.api.assembler.AccountOutputDTOAssembler;
import com.blueknights.bank.api.model.dto.input.AccountTransferInputDTO;
import com.blueknights.bank.api.model.dto.output.AccountOutputDTO;
import com.blueknights.bank.domain.model.Account;
import com.blueknights.bank.domain.service.AccountRegistrationService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountRegistrationService accountRegistrationService;

	@Autowired
	private AccountOutputDTOAssembler accountOutputDTOAssembler;

	@PostMapping("/{accountId}/transfer")
	public AccountOutputDTO buscar(@PathVariable Long accountId,
			@RequestBody @Valid AccountTransferInputDTO accountTranferInput) {
		Account originAccount = accountRegistrationService.fetchOrFail(accountId);
		Account destinationAccount = accountRegistrationService.fetchOrFail(accountTranferInput.getId());

		originAccount.setBalance(originAccount.getBalance().subtract(accountTranferInput.getValue()));
		accountRegistrationService.save(originAccount);

		destinationAccount.setBalance(destinationAccount.getBalance().add(accountTranferInput.getValue()));
		accountRegistrationService.save(destinationAccount);

		return accountOutputDTOAssembler.toDTO(destinationAccount);
	}

}
