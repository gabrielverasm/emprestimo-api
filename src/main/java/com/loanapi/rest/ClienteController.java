package com.loanapi.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.loanapi.model.entity.Cliente;
import com.loanapi.model.repository.ClientRepository;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin("http://localhost:4200")
public class ClienteController {

	private final ClientRepository clienteRepository;

	@Autowired
	public ClienteController(ClientRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@RequestBody @Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@GetMapping("{id}")
	public Cliente buscarPorId(@PathVariable Integer id) {
		return clienteRepository.findById(id).orElseThrow(() ->
		new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
