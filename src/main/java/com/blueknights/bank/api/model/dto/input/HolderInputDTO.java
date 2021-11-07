package com.blueknights.bank.api.model.dto.input;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HolderInputDTO {

	@NotBlank
	private String name;

	@Email
	private String email;

	@Valid
	@NotNull
	private List<AccountInputDTO> accounts = new ArrayList<AccountInputDTO>();
}
