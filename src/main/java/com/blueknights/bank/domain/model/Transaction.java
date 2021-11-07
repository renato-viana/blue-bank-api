package com.blueknights.bank.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Transaction {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_account_id")
    private Account originAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_account_id")
    private Account destinationAccount;

    @Column(name = "TRANSACTION_VALUE", nullable = false)
    private BigDecimal value;

    @Column(name = "TRANSACTION_DATE", nullable = false)
    @CreationTimestamp
    private OffsetDateTime transactionDate;

    public Transaction() {}

    public Transaction(Account originAccount, Account destinationAccount, BigDecimal value) {
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
        this.value = value;
    }
}
