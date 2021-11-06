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

    @Column(name = "CONTA_ORIGEN", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Account originAccount;

    @Column(name = "CONTA_DESTINO", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Account detinyAccount;

    @Column(name = "VALOR", nullable = false)
    private BigDecimal value;

    @Column(name = "DATA_TRANSACAO", nullable = false)
    @CreationTimestamp
    private OffsetDateTime transactionDate;
}
