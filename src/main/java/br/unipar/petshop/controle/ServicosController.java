package br.unipar.petshop.controle;

import br.unipar.petshop.modelo.Cliente;
import br.unipar.petshop.modelo.ClienteService;
import br.unipar.petshop.modelo.Servico;
import br.unipar.petshop.modelo.ServicoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/servicos")
public class ServicosController {

	private ServicoService servicoService;

	public ServicosController(ServicoService servicoService) {
		this.servicoService = servicoService;
	}
	
	@GetMapping
	public ModelAndView lista() {
		List<Servico> servicos = servicoService.listaTodos();
		
		ModelAndView resposta = new ModelAndView();
		resposta.setViewName("servicos/lista");
		resposta.addObject("servicos", servicos);
		
		return resposta;
	}
	
}
