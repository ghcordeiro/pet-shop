package br.unipar.petshop.controle;

import br.unipar.petshop.modelo.Cliente;
import br.unipar.petshop.modelo.ClienteService;
import br.unipar.petshop.modelo.Servico;
import br.unipar.petshop.modelo.ServicoService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/servicos/add")
public class ServicosAddController {

	private final ServicoService servicoService;

	public ServicosAddController(ServicoService servicoService) {
		this.servicoService = servicoService;
	}
	
	@GetMapping
	public ModelAndView formulario() {
		ModelAndView retorno = new ModelAndView();
		retorno.setViewName("servicos/form");
		retorno.addObject("servico", new Servico());
		return retorno;
	}
	
	@PostMapping
	public ModelAndView salva(@Valid Servico servico, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView retorno = new ModelAndView();
			retorno.setViewName("servicos/form");
			retorno.addObject("erros", getMensagensDeErro(bindingResult));
			retorno.addObject("servico", servico);
			return retorno;
		}
		servicoService.salva(servico);
		return new ModelAndView("redirect:/servicos");
	}
	
	public List<String> getMensagensDeErro(BindingResult bindingResult) {
		List<String> mensagens = new ArrayList<>();
		for (ObjectError erro : bindingResult.getAllErrors()) {
			mensagens.add(erro.getDefaultMessage());
		}
		return mensagens;
	}
	
}
