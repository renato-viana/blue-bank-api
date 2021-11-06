package com.blueknights.bank.domain.exception;

public class HolderNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1L;

	public HolderNotFoundException(String message) {
		super(message);
	}

	public HolderNotFoundException(Long id) {
		this(String.format("Não existe um cadastro de titular com código %d!", id));
	}
}
