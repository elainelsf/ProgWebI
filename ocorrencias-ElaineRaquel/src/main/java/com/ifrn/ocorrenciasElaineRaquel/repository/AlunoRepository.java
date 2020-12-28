package com.ifrn.ocorrenciasElaineRaquel.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ifrn.ocorrenciasElaineRaquel.model.Aluno;
import com.ifrn.ocorrenciasElaineRaquel.model.Ocorrencia;
import com.ifrn.ocorrenciasElaineRaquel.model.Turma;

@Repository
public class AlunoRepository {

	List<Aluno> alunos;
	
	public AlunoRepository() {
		
		alunos = new ArrayList<Aluno>();
		List<Ocorrencia> ocorrencias = new ArrayList<Ocorrencia>();
		
		Turma t1 = new Turma("TSI20191","TSI 3", 2019, 3);
		Aluno a1 = new Aluno("20191148060004", "Elaine", 1986, "99156-5623", "elis@gmail.com", t1);
		a1.setTurma(t1);
		a1.setOcorrencias(ocorrencias);
		alunos.add(a1);
		
		Turma t2 = new Turma("TSI20201","TSI 1", 2020, 1);
		Aluno a2 = new Aluno("20201148060022", "Maria", 1998, "99872-4369", "maria@gmail.com", t2);
		a2.setTurma(t2);
		a2.setOcorrencias(ocorrencias);
		alunos.add(a2);
		
		Turma t3 = new Turma("TINFO20201","INFO 3", 2020, 1);
		Aluno a3 = new Aluno("20201144030007", "João", 2002, "98825-4987", "joao@gmail.com", t3);
		a3.setTurma(t3);
		a3.setOcorrencias(ocorrencias);
		alunos.add(a3);
		
		Turma t4 = new Turma("MECA20202","MECA 2", 2020, 1);
		Aluno a4 = new Aluno("20191141130071", "Lucas", 2002, "99115-6226", "lucas@gmail.com", t4);
		a4.setTurma(t4);
		a4.setOcorrencias(ocorrencias);
		alunos.add(a4);
	}
	
	public Object getAllAlunos() {
		return this.alunos;
	}

	public void save(Aluno aluno) {
		this.alunos.add(aluno);
		
	}

	public Aluno getAlunobyMatricula(String matricula) {
		Aluno buscado = null;
		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().equals(matricula)) {
				buscado = aluno;
			}
		}
		return buscado;
	}

	public void remove(Aluno aluno) {
		alunos.remove(aluno);
		
	}

	public void editar(Aluno aluno) {
		Aluno a = new Aluno();
		a.setMatricula(aluno.getMatricula());
		a.setNome(aluno.getNome());
		a.setAnoNascimento(aluno.getAnoNascimento());
		a.setTelefone(aluno.getTelefone());
		a.setEmail(aluno.getEmail());
		a.setTurma(aluno.getTurma());
		a.setOcorrencias(aluno.getOcorrencias());
		System.out.println(a.toString());
		
	}



}
