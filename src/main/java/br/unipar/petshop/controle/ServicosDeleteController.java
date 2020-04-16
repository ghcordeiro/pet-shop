package br.unipar.petshop.controle;

import br.unipar.petshop.modelo.Cliente;
import br.unipar.petshop.modelo.ClienteService;
import br.unipar.petshop.modelo.Servico;
import br.unipar.petshop.modelo.ServicoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/servicos/{id}/delete")
public class ServicosDeleteController {

	private ServicoService servicoService;

	public ServicosDeleteController(ServicoService servicoService) {
		this.servicoService = servicoService;
	}
	
	@GetMapping
	public ModelAndView formulario(@PathVariable("id") Integer id) {
		Servico servico = servicoService.buscaPorId(id);
		
		ModelAndView retorno = new ModelAndView();
		retorno.setViewName("servicos/delete");
		retorno.addObject("servico", servico);
		return retorno;
	}
	
	@PostMapping
	public ModelAndView confirma(@PathVariable("id") Integer id) {
		servicoService.deletaPorId(id);
		return new ModelAndView("redirect:/servicos");
	}
	
}
