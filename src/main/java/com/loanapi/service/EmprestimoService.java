package com.loanapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.loanapi.model.entity.Cliente;
import com.loanapi.model.entity.Emprestimo;
import com.loanapi.model.entity.dto.ClienteModalidadeDTO;
import com.loanapi.util.EmprestimoConsignadoDisponivelUtil;
import com.loanapi.util.EmprestimoGarantiaDisponivelUtil;

@Service
public class EmprestimoService {
	
	private final EmprestimoConsignadoDisponivelUtil consignado;
	private final EmprestimoGarantiaDisponivelUtil emprestimoGarantia;
	
	public EmprestimoService(EmprestimoConsignadoDisponivelUtil consignado,
			EmprestimoGarantiaDisponivelUtil emprestimoGarantia) {
		this.consignado = consignado;
		this.emprestimoGarantia = emprestimoGarantia;
	}
	
	public ClienteModalidadeDTO EmprestimoDisponível(Cliente cliente) {
		List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		
		Emprestimo pessoal = new Emprestimo("Empréstimo Pessoal", 4);
		emprestimos.add(pessoal);
		
		
		if( consignado.disponível(cliente.getSalario()) ) {
			Emprestimo consignado = new Emprestimo("Empréstimo consignado", 2);
			emprestimos.add(consignado);
		}
		if (emprestimoGarantia.disponível(cliente)) {
			Emprestimo empGarantia = new Emprestimo("Empréstimo com garantia", 3);
			emprestimos.add(empGarantia);
		}
		
		ClienteModalidadeDTO clienteEmprestimo = new ClienteModalidadeDTO(cliente.getNome(), emprestimos);
		return clienteEmprestimo;
	}
}
