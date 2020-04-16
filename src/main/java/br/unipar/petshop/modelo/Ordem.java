package br.unipar.petshop.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ordem {

	private Integer id;

	private Animal animal;

	private Date data;

	private List<Servico> servico;

	@NotNull
	private List<Integer> quantidade;

	@NotNull
	private Double valorTotal;
}
