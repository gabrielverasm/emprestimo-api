package com.loanapi.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.loanapi.model.entity.Cliente;
import com.loanapi.model.entity.dto.ClienteModalidadeDTO;
import com.loanapi.model.repository.ClientRepository;
import com.loanapi.service.EmprestimoService;

@RestController
@RequestMapping("/api/emprestimo")
@CrossOrigin("http://localhost:4200")
public class EmprestimoController {

	private final ClientRepository clienteRepository;
	private final EmprestimoService service;

	@Autowired
	public EmprestimoController(ClientRepository clienteRepository, EmprestimoService service) {
		this.clienteRepository = clienteRepository;
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteModalidadeDTO consultarEmprestimo(@RequestBody @Valid Cliente cliente) {
		clienteRepository.save(cliente);
		return service.EmprestimoDisponível(cliente);
	}

}
