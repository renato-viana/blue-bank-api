package com.blueknights.bank.api.controller;

import com.blueknights.bank.domain.model.Transaction;
import com.blueknights.bank.domain.repository.TransactionRepository;
import com.blueknights.bank.domain.service.TransactionRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}
