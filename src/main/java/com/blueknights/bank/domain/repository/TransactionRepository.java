package com.blueknights.bank.domain.repository;

import com.blueknights.bank.domain.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
