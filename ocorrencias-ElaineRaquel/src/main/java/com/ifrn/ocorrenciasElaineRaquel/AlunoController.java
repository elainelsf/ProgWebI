package com.ifrn.ocorrenciasElaineRaquel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ifrn.ocorrenciasElaineRaquel.model.Aluno;
import com.ifrn.ocorrenciasElaineRaquel.model.Turma;
import com.ifrn.ocorrenciasElaineRaquel.repository.AlunoRepository;
import com.ifrn.ocorrenciasElaineRaquel.repository.TurmaRepository;

@Controller
public class AlunoController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	TurmaRepository turmaRepository;
	
	@GetMapping("/aluno")
	public String listarAluno(Model model) {
		model.addAttribute("alunos", alunoRepository.getAllAlunos());
		return "/aluno/list-aluno";
	}
	
	@GetMapping("/aluno/novo")
	public String novoAluno(Model model) {
		model.addAttribute("aluno", new Aluno());
		model.addAttribute("turmas", turmaRepository.getAllTurmas());
		return "/aluno/new-aluno";
	}
	
	@PostMapping("/aluno")
	public String salvarAluno(@RequestParam String codigo,
			@ModelAttribute Aluno aluno) {
		Turma turma = turmaRepository.getTurmabyCodigo(codigo);
		System.out.println(turma);
		aluno.setTurma(turma);
		turma.addAluno(aluno);
		alunoRepository.save(aluno);
		return "redirect:/aluno";
	}
	
	@GetMapping("/aluno/remove/{id}")
    public String removeAluno(@PathVariable("id") String matricula) {
		Aluno aluno = alunoRepository.getAlunobyMatricula(matricula);
		alunoRepository.remove(aluno);
		return "redirect:/aluno";
    }
	
	@GetMapping("/aluno/mostrar/{id}")
    public String mostrarAluno(@PathVariable("id") String id, @Validated Aluno aluno, BindingResult result,
            Model model) {
    	if (result.hasErrors()) {
            aluno.setMatricula(id);
            return "/aluno";
        }
        model.addAttribute("aluno", alunoRepository.getAlunobyMatricula(id));
    	return "/aluno/show-aluno";
    }
	
    /* Editar cadastro: consulta uma turma pelo código e realiza alterações nas informações cadastradas. */
	// Responsável por carregar a view com os dados preenchidos
    /*@GetMapping("/aluno/edit/{id}")		
	public ModelAndView editarAluno(@PathVariable("id") String matricula, Model model) {
 
		/*CONSULTA O ALUNO PELA MATRÍCULA *
		Aluno aluno = alunoRepository.getAlunobyMatricula(matricula);

		/*ADICIONANDO INFORMAÇÕES DA TURMA PARA MOSTRAR NA PÁGINA(VIEW)*
		model.addAttribute("aluno", aluno);
 
		/*CHAMA A VIEW /aluno/editar.html*
	    return new ModelAndView("/aluno/editar");
	 }
 
    // Responsável por salvar as alterações realizadas na turma selecionada
	@PostMapping("/salvarAlteracao")
	public ModelAndView salvarAlteracao(@ModelAttribute Aluno aluno){
 
		/* SALVANDO AS INFORMAÇÕES ALTERADAS DO ALUNO *
	    alunoRepository.editar(aluno);
 
		/*APÓS SALVAR VAMOS REDIRICIONAR O USUÁRIO PARA A PÁGINA DE CONSULTA*
		ModelAndView modelAndView = new ModelAndView("redirect:/aluno");
 
		/*RETORNANDO A VIEW*
		return modelAndView;
	}*/
}
