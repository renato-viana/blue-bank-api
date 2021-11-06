package com.blueknights.bank.api.model.dto.output;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountOutputDTO {

	private String number;
	private String agency;
	protected BigDecimal balance;
}
