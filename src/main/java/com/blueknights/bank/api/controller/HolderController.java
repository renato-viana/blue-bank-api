package com.blueknights.bank.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.blueknights.bank.api.assembler.HolderInputDTODisassembler;
import com.blueknights.bank.api.assembler.HolderOutputDTOAssembler;
import com.blueknights.bank.api.model.dto.input.HolderInputDTO;
import com.blueknights.bank.api.model.dto.output.HolderOutputDTO;
import com.blueknights.bank.domain.model.Holder;
import com.blueknights.bank.domain.repository.HolderRepository;
import com.blueknights.bank.domain.service.HolderRegistrationService;

@RestController
@RequestMapping("/holders")
public class HolderController {

	@Autowired
	private HolderRepository holderRepository;

	@Autowired
	private HolderRegistrationService holderRegistrationService;

	@Autowired
	private HolderOutputDTOAssembler holderOutputDTOAssembler;

	@Autowired
	private HolderInputDTODisassembler holderInputDTODisassembler;

	@GetMapping
	public List<HolderOutputDTO> listar() {
		List<Holder> holders = holderRepository.findAll();

		return holderOutputDTOAssembler.toCollectionDTO(holders);
	}

	@GetMapping("/{holderId}")
	public HolderOutputDTO buscar(@PathVariable Long holderId) {
		Holder holder = holderRegistrationService.fetchOrFail(holderId);

		return holderOutputDTOAssembler.toDTO(holder);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public HolderOutputDTO add(@RequestBody @Valid HolderInputDTO holderInput) {
		Holder holder = holderInputDTODisassembler.toDomainObject(holderInput);
		
		holder = holderRegistrationService.save(holder);

		return holderOutputDTOAssembler.toDTO(holder);
	}
}
