package com.blueknights.bank.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueknights.bank.api.model.dto.input.HolderInputDTO;
import com.blueknights.bank.domain.model.Holder;

@Component
public class HolderInputDTODisassembler {

	@Autowired
	private ModelMapper modelMapper;

	public Holder toDomainObject(HolderInputDTO holderInput) {

		return modelMapper.map(holderInput, Holder.class);
	}

	public void copyToDomainObject(HolderInputDTO holderInput, Holder holder) {
		modelMapper.map(holderInput, holder);
	}
}
