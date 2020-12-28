package com.ifrn.ocorrenciasElaineRaquel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import com.ifrn.ocorrenciasElaineRaquel.repository.AlunoRepository;
import com.ifrn.ocorrenciasElaineRaquel.repository.OcorrenciaRepository;
//import com.ifrn.ocorrenciasElaineRaquel.repository.TurmaRepository;

@Controller
public class OcorrenciaController {
	/*@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	TurmaRepository turmaRepository;
	*/
	
	@Autowired
	OcorrenciaRepository ocorrenciaRepository;
	
	@GetMapping("/ocorrencia")
	public String listarOcorrencia(Model model) {
		
		model.addAttribute("ocorrencias", ocorrenciaRepository.getAllOcorrencias());
		
		return "/ocorrencia/list-ocorrencia";
	}
}
