package com.blueknights.bank.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		
//		var enderecoToEnderecoOutputDTOTypeMap = modelMapper.createTypeMap(
//				Endereco.class, EnderecoOutputDTO.class);
		
//		enderecoToEnderecoOutputDTOTypeMap.<String>addMapping(
//				src -> src.getCidade().getEstado().getNome(),
//				(dest, value) -> dest.getCidade().setEstado(value));
		
		return modelMapper;
	}
}
