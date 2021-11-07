package com.blueknights.bank.domain.exception;

public class InsufficientFundsException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException() {
        this("Você não tem saldo suficiente para completar a operação");
    }
}
