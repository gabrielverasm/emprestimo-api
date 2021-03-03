package com.loanapi.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.loanapi.model.entity.Cliente;

@Component
public class EmprestimoGarantiaDisponivelUtil {
	
	public Boolean disponível(Cliente cliente) {
		
		if( (cliente.getSalario().compareTo(new BigDecimal(3000)) <= 0) && 
				(cliente.getIdade() < 30) && (cliente.getUf().toUpperCase().equals("CE")) ) {
			return true;
		}
		else if( (cliente.getSalario().compareTo(new BigDecimal(3000)) > 0) &&
				(cliente.getSalario().compareTo(new BigDecimal(5000)) < 0) &&
				(cliente.getUf().toUpperCase().equals("CE")) ) {
			return true;
		}
		else if ((cliente.getSalario().compareTo(new BigDecimal(5000)) >= 0 ) && (cliente.getIdade() < 30)) {
			return true;
		}
		
		return false;
	}

}
