package br.unipar.petshop.controle;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.unipar.petshop.modelo.Animal;
import br.unipar.petshop.modelo.AnimalService;
import br.unipar.petshop.modelo.Cliente;
import br.unipar.petshop.modelo.ClienteService;

@Controller      
@RequestMapping("/animais/{id}/edit")
public class AnimaisEditController {

	private final AnimalService animalService;
	private final ClienteService clienteService;
	
	public AnimaisEditController(AnimalService animalService, ClienteService clienteService) {
		this.animalService = animalService;
		this.clienteService = clienteService;
	}
	
	@GetMapping
	public ModelAndView formulario(@PathVariable("id") Integer id) {
		Animal animal = animalService.buscaPorId(id);
		List<Cliente> clientes = clienteService.listaTodos();
		
		ModelAndView retorno = new ModelAndView();
		retorno.setViewName("animais/form");
		retorno.addObject("animal", animal);
		retorno.addObject("clientes", clientes);
		return retorno;
	}
	
	@PostMapping
	public ModelAndView formulario(@Valid Animal animal, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<Cliente> clientes = clienteService.listaTodos();
			
			ModelAndView retorno = new ModelAndView();
			retorno.setViewName("animais/form");
			retorno.addObject("animal", animal);
			retorno.addObject("clientes", clientes);
			return retorno;
		}
		
		Cliente dono = clienteService.buscaPorId(animal.getDono().getId());
		animal.setDono(dono);
		
		animalService.salva(animal);
		return new ModelAndView("redirect:/animais");
	}
	
}
