package br.unipar.petshop.controle;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
@RequestMapping("/clientes/{id}/edit")
public class ClientesEditController {

	private final ClienteService clienteService;
	
	public ClientesEditController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping
	public ModelAndView formulario(@PathVariable("id") Integer id) {
		Cliente cliente = clienteService.buscaPorId(id);
		
		ModelAndView retorno = new ModelAndView();
		retorno.setViewName("clientes/form");
		retorno.addObject("cliente", cliente);
		return retorno;
	}
	
	@PostMapping
	public ModelAndView formulario(@Valid Cliente cliente, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			ModelAndView retorno = new ModelAndView();
			retorno.setViewName("clientes/form");
			retorno.addObject("erros", getMensagensDeErro(bindingResult));
			retorno.addObject("cliente", cliente);
			return retorno;
		}
		clienteService.salva(cliente);
		return new ModelAndView("redirect:/clientes");
	}
	
	public List<String> getMensagensDeErro(BindingResult bindingResult) {
		List<String> mensagens = new ArrayList<>();
		for (ObjectError erro : bindingResult.getAllErrors()) {
			mensagens.add(erro.getDefaultMessage());
		}
		return mensagens;
	}
	
}
