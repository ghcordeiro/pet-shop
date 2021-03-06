package br.unipar.petshop.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	private Integer id;

	@NotNull(message = "Nome não pode ser nulo")
	@Size(min = 3, message = "Nome deve ter pelo menos 3 caracteres")
	private String nome;

	@NotNull(message = "CPF não pode ser nulo")
	@Size(min = 3, max = 11, message = "CPF deve ter 11 caracteres")
	private String cpf;
	
}
