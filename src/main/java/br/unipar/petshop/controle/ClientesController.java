package br.unipar.petshop.controle;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.unipar.petshop.modelo.Cliente;
import br.unipar.petshop.modelo.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	private ClienteService clienteService;
	
	public ClientesController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping
	public ModelAndView lista() {
		List<Cliente> clientes = clienteService.listaTodos();
		
		ModelAndView resposta = new ModelAndView();
		resposta.setViewName("clientes/lista");
		resposta.addObject("clientes", clientes);
		
		return resposta;
	}
	
}
