package com.blueknights.bank.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Embeddable
public class Account {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_holder_id")
	private Holder holder;

	@Column(name = "account_number", nullable = false)
	private String number;

	@Column(name = "account_agency", nullable = false)
	private String agency;

	@Column(name = "account_balance", nullable = false)
	protected BigDecimal balance;

}
