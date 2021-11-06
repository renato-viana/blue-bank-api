package com.blueknights.bank.api.model.dto.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountInputDTO {

	@NotBlank
	private String number;
	
	@NotBlank
	private String agency;
	
	@NotNull
	@PositiveOrZero
	protected BigDecimal balance;
}
