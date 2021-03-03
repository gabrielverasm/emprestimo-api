package com.loanapi.model.entity.dto;

import java.util.List;

import com.loanapi.model.entity.Emprestimo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteModalidadeDTO {

	private String cliente;
	private List<Emprestimo> modalidades;
}
