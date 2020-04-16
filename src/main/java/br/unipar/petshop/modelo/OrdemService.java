package br.unipar.petshop.modelo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrdemService {

	private static List<Ordem> ordens = new ArrayList<>();
	private static Integer codigoAtual = 3;

	public OrdemService() {

	}
	
	public List<Ordem> listaTodos() {
		return ordens;
	}
	
	public void salva(Ordem ordem) {
		if (ordem.getId() == null) {
			inclui(ordem);
		} else {
			atualiza(ordem);
		}
	}
	
	private void inclui(Ordem ordem) {
		codigoAtual++;
		ordem.setId(codigoAtual);
		ordens.add(ordem);
	}
	
	private void atualiza(Ordem ordem) {
		for (int i = 0; i < ordens.size(); i++) {
			if (ordens.get(i).getId() == ordem.getId()) {
				ordens.set(i, ordem);
				return;
			}
		}
	}
	
	public Ordem buscaPorId(Integer id) {
		for (Ordem ordem : ordens) {
			if (ordem.getId().equals(id)) {
				return ordem;
			}
		}
		return null;
	}
	
	public void deletaPorId(Integer id) {
		Ordem ordem = buscaPorId(id);
		ordens.remove(ordem);
	}
	
}
