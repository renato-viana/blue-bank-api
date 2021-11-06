package com.blueknights.bank.api.assembler;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blueknights.bank.api.model.dto.output.HolderOutputDTO;
import com.blueknights.bank.domain.model.Holder;

@Component
public class HolderOutputDTOAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public HolderOutputDTO toDTO(Holder holder) {
		return modelMapper.map(holder, HolderOutputDTO.class);
	}

	public List<HolderOutputDTO> toCollectionDTO(Collection<Holder> holders) {
		return holders.stream().map(holder -> toDTO(holder)).collect(Collectors.toList());
	}
}
