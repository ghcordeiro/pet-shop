package br.unipar.petshop.modelo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

	public enum Especie { CACHORRO, GATO, PASSARO }
	
	private Integer id;
	
	@NotNull(message = "Nome não pode ser nulo")
	@Size(min = 3, message = "Nome deve ter pelo menos 3 caracteres")
	private String nome;
	
	@NotNull(message = "Espécie não pode ser nula")
	private Especie especie;
	
	private Cliente dono;
	
}
