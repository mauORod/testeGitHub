package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.models.SessaoFilme;
import br.com.fiap.repository.SessaoFilmeRepository;

@Controller
public class SessaoFilmeController {

	@RequestMapping(value = { "/sessao" }, method = RequestMethod.GET)
	public String getAll(Model model) {

		return "sessao-filme-listar";
	}

	@RequestMapping(value = { "/sessao/{codigoUrl}" }, method = RequestMethod.GET)
	public String detalhe(@PathVariable("codigoUrl") long idConsulta, Model springModel) {

		SessaoFilmeRepository r = new SessaoFilmeRepository();
		SessaoFilme modelo = r.get(idConsulta);

		springModel.addAttribute("filme", modelo);

		return "sessao-filme-detalhe";
	}

	@RequestMapping(value = { "sessao-filme-edicao/{codigoUrl}" }, method = RequestMethod.GET)
	public String edicao(@PathVariable("codigoUrl") long idConsultaEdicaoModel, Model model) {

		SessaoFilmeRepository r = new SessaoFilmeRepository();
		//SessaoFilme filme = r.get(idConsultaEdicaoModel);
		
		//model.addAttribute("filme", filme);
		model.addAttribute("filme", new SessaoFilmeRepository().get(idConsultaEdicaoModel));
		return "sessao-filme-edicao";
	}

}
