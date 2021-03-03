package com.loanapi.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class EmprestimoConsignadoDisponivelUtil {
	
	public Boolean disponível(BigDecimal salario) {
		return (salario.compareTo(new BigDecimal(5000)) >= 0) ? true : false;
	}

}
