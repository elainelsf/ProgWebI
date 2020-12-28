package com.ifrn.ocorrenciasElaineRaquel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifrn.ocorrenciasElaineRaquel.model.Turma;
import com.ifrn.ocorrenciasElaineRaquel.repository.TurmaRepository;

@Controller
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepository;
	
	@GetMapping("/turma")
	public String listTurma( Model model ) {
		model.addAttribute("turmas", turmaRepository.getAllTurmas());
		return "/turma/list-turma";
	}
	
	@GetMapping("/turma/novo")
	public String newTurma( Model model ) {
		model.addAttribute("turma", new Turma());
		return "/turma/new-turma";
	}

	@PostMapping("/turma")
	public String saveTurma(@ModelAttribute Turma turma) {
		turmaRepository.save(turma);
		return "redirect:turma";
	}
	
	@GetMapping("/turma/remove/{id}")
    public String removeTurma(@PathVariable("id") String codigo) {
		System.out.println(codigo);
		//turmaRepository.findById(codigo);
		turmaRepository.remove(codigo);
        //return "/turma/list-turma";
		return "redirect:/turma";
    }

    @GetMapping("/turma/mostrar/{id}")
    public String mostrarTurma(@PathVariable("id") String id, @Validated Turma turma, BindingResult result,
            Model model) {
    	if (result.hasErrors()) {
            turma.setCodigo(id);
            return "turma/update-turma";
        }
        model.addAttribute("turma", turmaRepository.getTurmabyCodigo(id));
    	return "/turma/show-turma";
    }


    /* Editar cadastro: consulta uma turma pelo código e realiza alterações nas informações cadastradas. */
	// Responsável por carregar a view com os dados preenchidos
    @GetMapping("/turma/edit/{id}")		
	public ModelAndView editarTurma(@PathVariable("id") String codigo, Model model) {
 
		/*CONSULTA A TURMA PELO CÓDIGO*/
		Turma turma = turmaRepository.findById(codigo);

		/*ADICIONANDO INFORMAÇÕES DA TURMA PARA MOSTRAR NA PÁGINA(VIEW)*/
		model.addAttribute("turma", turma);
 
		/*CHAMA A VIEW /turma/editar.html*/
	    return new ModelAndView("/turma/editar");
	 }
 
    // Responsável por salvar as alterações realizadas na turma selecionada
	@PostMapping("/salvarAlteracao")
	public ModelAndView salvarAlteracao(@ModelAttribute Turma turma){
 
		/* SALVANDO AS INFORMAÇÕES ALTERADAS DA TURMA */
	    turmaRepository.editar(turma);
 
		/*APÓS SALVAR VAMOS REDIRICIONAR O USUÁRIO PARA A PÁGINA DE CONSULTA*/
		ModelAndView modelAndView = new ModelAndView("redirect:/turma");
 
		/*RETORNANDO A VIEW*/
		return modelAndView;
	}
}
