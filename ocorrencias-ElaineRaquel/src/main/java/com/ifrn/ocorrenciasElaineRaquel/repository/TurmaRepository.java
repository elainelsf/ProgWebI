package com.ifrn.ocorrenciasElaineRaquel.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ifrn.ocorrenciasElaineRaquel.model.Aluno;
import com.ifrn.ocorrenciasElaineRaquel.model.Turma;

@Repository
public class TurmaRepository {

	private List<Turma> turmas;

	public TurmaRepository() {
		turmas = new ArrayList<Turma>();
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		Turma t1 = new Turma("TSI 3", "TSI20191", 2019, 3);
		t1.setAlunos(alunos);
		turmas.add(t1);
		
		Turma t2 = new Turma("TSI 1", "TSI20201", 2020, 1);
		t2.setAlunos(alunos);
		turmas.add(t2);
		
		Turma t3 = new Turma("INFO 3", "INFO20201", 2020, 1);
		t3.setAlunos(alunos);
		turmas.add(t3);
		
		Turma t4 = new Turma("MECA 2", "MECA20201", 2020, 1);
		t4.setAlunos(alunos);
		turmas.add(t4);
	}
	
	public List<Turma> getAllTurmas( ) {
		return this.turmas;
	}
	
	public Turma findById( String id ) {
		Turma turma = new Turma();
		
		for (Turma t : turmas) {
			if (t.getCodigo().equals(id)) { turma = t; }
		}
		//System.out.println("codigo: " + turma.getCodigo());
		return turma;
	}

	public void save( Turma turma ) {
		turma.setAlunos(new ArrayList<Aluno>());
		turmas.add(turma);
		
	}
	
	public Turma edit( Turma turma ) {
		System.out.println("TURMA EDIT");
		return turma;
	}
	
	public void remove( Turma turma ) {
		turmas.remove(turma);
	}

	public void remove(String codigo) {
		Turma t = new Turma();
		t = findById(codigo);
		System.out.println("codigo da turma: " + t.getCodigo());
		System.out.println("index: " + turmas.indexOf(t));
		turmas.remove(turmas.indexOf(t));
		
	}

	public Turma getTurmabyCodigo(String codigo) {
		Turma buscada = null;
		for (Turma turma : turmas) {
			if (turma.getCodigo().equals(codigo)) {
				buscada = turma;
			}
		}
		return buscada;
	}

	public void editar(Turma turma) {
		Turma t = new Turma();
		t = findById(turma.getCodigo());
		System.out.println("Meu nome é: " + t.getNome());
		t.setCodigo(turma.getCodigo());
		t.setNome(turma.getNome());
		t.setAno(turma.getAno());
		t.setPeriodo(turma.getPeriodo());
		t.setAlunos(turma.getAlunos());
		System.out.println(t.toString());
	}
}
