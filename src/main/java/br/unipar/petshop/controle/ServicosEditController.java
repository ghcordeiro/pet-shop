package br.unipar.petshop.controle;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import br.unipar.petshop.modelo.Servico;
import br.unipar.petshop.modelo.ServicoService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.unipar.petshop.modelo.Cliente;
import br.unipar.petshop.modelo.ClienteService;

@Controller
@RequestMapping("/servicos/{id}/edit")
public class ServicosEditController {

	private final ServicoService servicoService;

	public ServicosEditController(ServicoService servicoService) {
		this.servicoService = servicoService;
	}

	@GetMapping
	public ModelAndView formulario(@PathVariable("id") Integer id) {
		Servico servico = servicoService.buscaPorId(id);

		ModelAndView retorno = new ModelAndView();
		retorno.setViewName("servicos/form");
		retorno.addObject("servico", servico);
		return retorno;
	}

	@PostMapping
	public ModelAndView formulario(@Valid Servico servico, BindingResult bindingResult) {
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
