package com.loanapi.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 200)
	@NotEmpty(message = "{cliente.nome.obrigatorio}")
	private String nome;
	
	@Column(nullable = false, length = 11)
	@CPF(message ="{cliente.cpf.invalido}")
	@NotNull(message = "{cliente.cpf.obrigatorio}")
	private String cpf;
	
	@Column(nullable = false, length = 3)
	@NotNull(message = "{cliente.idade.obrigatorio}")
	private Integer idade;
	
	@Column(nullable = false, length = 2)
	@NotNull(message = "{cliente.uf.obrigatorio}")
	private String uf;
	
	@Column(nullable = false)
	@NotNull(message = "{cliente.salario.obrigatorio}")
	@DecimalMin(value = "0.0", inclusive = false, message = "{cliente.salario.valorMinimo}")
	private BigDecimal salario;
	
	@Column(name = "registro_data")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate registroData;
	
	@PrePersist
	public void prePersist() {
		setRegistroData(LocalDate.now());
	}
}
