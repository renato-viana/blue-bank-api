package com.blueknights.bank.api.controller;

import javax.validation.Valid;

import com.blueknights.bank.domain.exception.InsufficientFundsException;
import com.blueknights.bank.domain.model.Transaction;
import com.blueknights.bank.domain.service.TransactionRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountRegistrationService accountRegistrationService;

	@Autowired
	private TransactionRegistrationService transactionRegistrationService;

	@Autowired
	private AccountOutputDTOAssembler accountOutputDTOAssembler;

	@PostMapping("/{accountId}/transfer")
	public Map<String, String> buscar(@PathVariable Long accountId,
									  @RequestBody @Valid AccountTransferInputDTO accountTranferInput) {
		Account originAccount = accountRegistrationService.fetchOrFail(accountId);
		Account destinationAccount = accountRegistrationService.fetchOrFail(accountTranferInput.getId());

		if (originAccount.getBalance().compareTo(accountTranferInput.getValue()) < 0) {
			throw new InsufficientFundsException();
		}

		Transaction transaction = new Transaction(originAccount, destinationAccount, accountTranferInput.getValue());
		transactionRegistrationService.save(transaction);

		originAccount.setBalance(originAccount.getBalance().subtract(accountTranferInput.getValue()));
		accountRegistrationService.save(originAccount);

		destinationAccount.setBalance(destinationAccount.getBalance().add(accountTranferInput.getValue()));
		accountRegistrationService.save(destinationAccount);

		Map<String, String> map = new HashMap<>();
		map.put("message", "Transferencia executada com sucesso");

		return map;
	}

}