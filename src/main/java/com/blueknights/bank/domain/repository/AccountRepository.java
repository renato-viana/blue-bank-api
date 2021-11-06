package com.blueknights.bank.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blueknights.bank.domain.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
