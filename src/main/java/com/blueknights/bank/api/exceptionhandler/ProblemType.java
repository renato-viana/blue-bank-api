package com.blueknights.bank.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	INCOMPREHENSIBLE_MESSAGE("/mensagem-incompreensivel",
			"Mensagem incompreensível"),
	RESOURCE_NOT_FOUND("/recurso-nao-encontrado", "recurso não encontrado"),
	ENTITY_IN_USE("/entidade-em-uso", "Entidade em uso"),
	BUSINESS_ERROR("/erro-negocio", "Violação de regra de negócio"),
	INVALID_PARAMETER("/parametro-invalido", "Parâmetro inválido"),
	SYSTEM_ERROR("/erro-de-sistema", "Erro de sistema"),
	INVALID_DATA("/dados-invalidos", "Dados inválidos");

	private String title;
	private String uri;

	private ProblemType(String path, String title) {
		this.uri = "https://bluebank.com.br" + path;
		this.title = title;
	}
}
