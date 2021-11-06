package com.blueknights.bank.domain.exception;

public class AccountNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String message) {
		super(message);
	}

	public AccountNotFoundException(Long id) {
		this(String.format("Não existe um cadastro de conta com código %d!", id));
	}
}
