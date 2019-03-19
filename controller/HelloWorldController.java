package br.com.fiap.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.models.AlunoModel;


@Controller
public class HelloWorldController {
	
	@RequestMapping(value= {"/hello", "/"}, method = RequestMethod.GET)
	public String helloWorld(Model model) {
		
		List<String> lista = new ArrayList<String>();
		lista.add( "Retorno 1" );
		lista.add( "Retorno 2" );
		lista.add( "" );
		lista.add( "Retorno 3" );
		
		model.addAttribute("listaRetorno",  lista );
		
		return "hello";
	}

}
