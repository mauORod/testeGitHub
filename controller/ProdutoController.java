package br.com.fiap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.models.ProdutoModel;
import br.com.fiap.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	
	
	
	@RequestMapping( value= {"/produto"} , method = RequestMethod.GET )
	public String get(Model model) {
		
		ProdutoRepository produtoRepository = new ProdutoRepository();
		
		List<ProdutoModel> lista = produtoRepository.get();
		
		model.addAttribute("produtos" , lista);
		
		return "produtos";
	}
	
	
	@RequestMapping(value= {"/produto/{id}"} , method = RequestMethod.GET)
	public String get(@PathVariable("id")  long id, Model model) {
		ProdutoRepository produtoRepository = new ProdutoRepository();
		ProdutoModel prodModel = produtoRepository.get(id);
		model.addAttribute("produto" , prodModel);
		return "produtos-detalhe";
	}
	
	
	// Ação apenas para abrir a tela do formulário
	@RequestMapping(value= {"/produto/new"} , method = RequestMethod.GET)
	public String newProduct(Model model) {
		return "produto-novo";
	}
	
	// Ação que irá receber os dados do formulário e preencher "Automagicamente" o ProdutoModel
	@RequestMapping(value= {"/produto/new"} , method = RequestMethod.POST)
	public String newProduct(
			ProdutoModel produtoModel, Model model) {
		ProdutoRepository produtoRepository = 
				new ProdutoRepository();
		produtoRepository.newProduct(produtoModel);
		return "produto-novo-sucesso";
	}
	
	
}
