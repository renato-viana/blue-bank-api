package com.blueknights.bank.domain.exception;

public class InsufficientFundsException extends BusinessException {

    public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException() {
        this("Você não tem saldo suficiente para completar a operação");
    }
}
