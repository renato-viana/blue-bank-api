package com.blueknights.bank.api.model.dto.output;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HolderOutputDTO {

	private Long id;
	private String cpf;
	private String name;
	private String email;
	private OffsetDateTime creationDate;
	private List<AccountOutputDTO> accounts = new ArrayList<AccountOutputDTO>();
}
