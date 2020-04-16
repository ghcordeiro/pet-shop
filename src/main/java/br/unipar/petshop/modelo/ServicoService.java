package br.unipar.petshop.modelo;

import br.unipar.petshop.modelo.Animal.Especie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoService {

	private static List<Servico> servicos = new ArrayList<>();
	private static Integer codigoAtual = 3;

	public ServicoService() {
		servicos.add(new Servico(1, "Banho", 15.00));
		servicos.add(new Servico(2, "Tosa", 35.00));
		servicos.add(new Servico(3, "Vacina", 85.00));
	}
	
	public List<Servico> listaTodos() {
		return servicos;
	}
	
	public void salva(Servico servico) {
		if (servico.getId() == null) {
			inclui(servico);
		} else {
			atualiza(servico);
		}
	}
	
	private void inclui(Servico servico) {
		codigoAtual++;
		servico.setId(codigoAtual);
		servicos.add(servico);
	}
	
	private void atualiza(Servico servico) {
		for (int i = 0; i < servicos.size(); i++) {
			if (servicos.get(i).getId() == servico.getId()) {
				servicos.set(i, servico);
				return;
			}
		}
	}
	
	public Servico buscaPorId(Integer id) {
		for (Servico servico : servicos) {
			if (servico.getId().equals(id)) {
				return servico;
			}
		}
		return null;
	}
	
	public void deletaPorId(Integer id) {
		Servico servico = buscaPorId(id);
		servicos.remove(servico);
	}
	
}
