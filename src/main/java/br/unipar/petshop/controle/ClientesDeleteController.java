package br.unipar.petshop.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.unipar.petshop.modelo.Cliente;
import br.unipar.petshop.modelo.ClienteService;

@Controller
@RequestMapping("/clientes/{id}/delete")
public class ClientesDeleteController {

	private ClienteService clienteService;
	
	public ClientesDeleteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping
	public ModelAndView formulario(@PathVariable("id") Integer id) {
		Cliente cliente = clienteService.buscaPorId(id);
		
		ModelAndView retorno = new ModelAndView();
		retorno.setViewName("clientes/delete");
		retorno.addObject("cliente", cliente);
		return retorno;
	}
	
	@PostMapping
	public ModelAndView confirma(@PathVariable("id") Integer id) {
		clienteService.deletaPorId(id);
		return new ModelAndView("redirect:/clientes");
	}
	
}
