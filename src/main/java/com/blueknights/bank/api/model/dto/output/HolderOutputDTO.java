package com.blueknights.bank.api.model.dto.output;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HolderOutputDTO {

	private Long id;
	private String name;
	private String email;
	private List<AccountOutputDTO> accounts = new ArrayList<AccountOutputDTO>();
}
