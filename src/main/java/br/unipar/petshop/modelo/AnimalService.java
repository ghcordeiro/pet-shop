package br.unipar.petshop.modelo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.unipar.petshop.modelo.Animal.Especie;

@Service
public class AnimalService {

	private static List<Animal> animais = new ArrayList<>();
	private static Integer codigoAtual = 3;
	
	public AnimalService(ClienteService clienteService) {
		Cliente dono = clienteService.buscaPorId(1);
		
		animais.add(new Animal(1, "Totó", Especie.CACHORRO, dono));
		animais.add(new Animal(2, "Jerry", Especie.GATO, dono));
		animais.add(new Animal(3, "Piu piu", Especie.PASSARO, dono));
	}
	
	public List<Animal> listaTodos() {
		return animais;
	}
	
	public void salva(Animal animal) {
		if (animal.getId() == null) {
			inclui(animal);
		} else {
			atualiza(animal);
		}
	}
	
	private void inclui(Animal animal) {
		codigoAtual++;
		animal.setId(codigoAtual);
		animais.add(animal);
	}
	
	private void atualiza(Animal animal) {
		for (int i = 0; i < animais.size(); i++) {
			if (animais.get(i).getId() == animal.getId()) {
				animais.set(i, animal);
				return;
			}
		}
	}
	
	public Animal buscaPorId(Integer id) {
		for (Animal animal : animais) {
			if (animal.getId() == id) {
				return animal;
			}
		}
		return null;
	}
	
	public void deletaPorId(Integer id) {
		Animal animal = buscaPorId(id);
		animais.remove(animal);
	}
	
}
