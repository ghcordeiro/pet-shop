package br.unipar.petshop.modelo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	private static List<Cliente> clientes = new ArrayList<>();
	private static Integer codigoAtual = 3;
	
	public ClienteService() {
		clientes.add(new Cliente(1, "João", "00011122233"));
		clientes.add(new Cliente(2, "Maria", "11122233344"));
		clientes.add(new Cliente(3, "José", "22233344455"));
	}
	
	public List<Cliente> listaTodos() {
		return clientes;
	}

	public void salva(Cliente cliente) {
		if (cliente.getId() == null) {
			inclui(cliente);
		} else {
			atualiza(cliente);
		}
	}
	
	private void inclui(Cliente cliente) {
		codigoAtual++;
		cliente.setId(codigoAtual);
		clientes.add(cliente);
	}
	
	private void atualiza(Cliente cliente) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getId() == cliente.getId()) {
				clientes.set(i, cliente);
				return;
			}
		}
	}
	
	public Cliente buscaPorId(Integer id) {
		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				return cliente;
			}
		}
		return null;
	}
	
	public void deletaPorId(Integer id) {
		Cliente cliente = buscaPorId(id);
		clientes.remove(cliente);
	}
	
}
