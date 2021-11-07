package com.blueknights.bank.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blueknights.bank.domain.model.Transaction;
import com.blueknights.bank.domain.repository.TransactionRepository;

@Service
public class TransactionRegistrationService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Transactional
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
