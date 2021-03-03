package com.loanapi.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loanapi.model.entity.Cliente;

public interface ClientRepository extends JpaRepository<Cliente, Integer> {
	
	

}
