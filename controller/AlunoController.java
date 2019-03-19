package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.fiap.models.AlunoModel;

@Controller
public class AlunoController {

	
	@RequestMapping( value = {"/aluno"} , method = RequestMethod.GET  )
	public String getAluno(Model model) {
		
		List<AlunoModel> lista = new ArrayList<AlunoModel>();
		lista.add( new AlunoModel("Flavio", "RM123456", "3SIA") );
		lista.add( new AlunoModel("Eduardo", "RM987654", "3SIB") );
		lista.add( new AlunoModel("Moreni", "RM123456", "3SIA") );
		lista.add( new AlunoModel("Flavio", "RM123456", "3SIB") );
		
		model.addAttribute("alunos",  lista );
		
		return "aluno";
	}
	
	
	@RequestMapping( value = {"/alunoDetalhe"} , method = RequestMethod.GET  )
	public String getAlunoDetalhe(Model model) {
		model.addAttribute("aluno", new AlunoModel("Flavio", "RM123456", "3SIA") );
		return "alunoDetalhe";
	}
	
}
