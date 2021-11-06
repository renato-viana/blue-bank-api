package com.blueknights.bank.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;

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
    @JoinColumn(name = "destiny_account_id")
    private Account destinyAccount;

    @Column(name = "TRANSACTION_VALUE", nullable = false)
    private BigDecimal value;

    @Column(name = "TRANSACTION_DATE", nullable = false)
    @CreationTimestamp
    private OffsetDateTime transactionDate;

    public Transaction() {}

    public Transaction(Account originAccount, Account destinyAccount, BigDecimal value) {
        this.originAccount = originAccount;
        this.destinyAccount = destinyAccount;
        this.value = value;
    }
}
