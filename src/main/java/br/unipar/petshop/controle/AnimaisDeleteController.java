package br.unipar.petshop.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.unipar.petshop.modelo.Animal;
import br.unipar.petshop.modelo.AnimalService;

@Controller
@RequestMapping("/animais/{id}/delete")
public class AnimaisDeleteController {

	private AnimalService animalService;
	
	public AnimaisDeleteController(AnimalService animalService) {
		this.animalService = animalService;
	}
	
	@GetMapping
	public ModelAndView formulario(@PathVariable("id") Integer id) {
		Animal animal = animalService.buscaPorId(id);
		
		ModelAndView retorno = new ModelAndView();
		retorno.setViewName("animais/delete");
		retorno.addObject("animal", animal);
		return retorno;
	}
	
	@PostMapping
	public ModelAndView confirma(@PathVariable("id") Integer id) {
		animalService.deletaPorId(id);
		return new ModelAndView("redirect:/animais");
	}
	
}
