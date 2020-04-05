package br.unipar.petshop.controle;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.unipar.petshop.modelo.Animal;
import br.unipar.petshop.modelo.AnimalService;

@Controller
@RequestMapping("/animais")
public class AnimaisController {

	private AnimalService animalService;
	
	public AnimaisController(AnimalService animalService) {
		this.animalService = animalService;
	}
	
	@GetMapping
	public ModelAndView lista() {
		List<Animal> animais = animalService.listaTodos();
		
		ModelAndView resposta = new ModelAndView();
		resposta.setViewName("animais/lista");
		resposta.addObject("animais", animais);
		
		return resposta;
	}
	
}
