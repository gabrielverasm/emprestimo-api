package com.loanapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Emprestimo {

//	PESSOAL("Empréstimo Pessoal", 4),
//	GARANTIA("Empréstimo com Garantia", 3),
//	CONSIGNADO("Empréstimo Consignado", 2);
	
	private String descricao;
	private Integer taxa;
}
