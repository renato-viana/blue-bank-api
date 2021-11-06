package com.blueknights.bank.api.model.dto.input;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountTransferInputDTO {

	@NotNull
	private Long id;
	
	@NotNull
	@PositiveOrZero
	protected BigDecimal value;
}
