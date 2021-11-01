package com.blueknights.bank.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blueknights.bank.domain.model.Holder;
import com.blueknights.bank.domain.service.AccountRegistrationService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountRegistrationService accountRegistrationService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Holder adicionar(@RequestBody @Valid Holder holder) {

		holder = accountRegistrationService.salvar(holder);

		return holder;
	}
}
