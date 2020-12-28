package com.ifrn.ocorrenciasElaineRaquel.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ifrn.ocorrenciasElaineRaquel.model.Aluno;
import com.ifrn.ocorrenciasElaineRaquel.model.Ocorrencia;
import com.ifrn.ocorrenciasElaineRaquel.model.StatusOcorrencia;
import com.ifrn.ocorrenciasElaineRaquel.model.Turma;

@Repository
public class OcorrenciaRepository {
	
	private int contador = 0;
	private List<Ocorrencia> ocorrencias;

	public OcorrenciaRepository( ) {
		ocorrencias = new ArrayList<Ocorrencia>();
		
		StatusOcorrencia  status = StatusOcorrencia.ANALISE;
		/*Calendar horaAtual = 
				Calendar c = Calendar.getInstance();
		System.out.println("Data e Hora atual: ”+c.getTime());*/
		
		Aluno a1 = new AlunoRepository().getAlunobyMatricula("20191141130071");
		Ocorrencia oc1 = new Ocorrencia("Perda de material", "Perdeu livro da biblioteca", a1, status);
		ocorrencias.add(oc1);
		Ocorrencia oc2 = new Ocorrencia("Depredação", "Pichou a porta do banheiro masculino do 1o andar", a1, status);
		ocorrencias.add(oc2);
		Ocorrencia oc3 = new Ocorrencia("Comportamento inadequado", "Subiu na mesa do refeitório", a1, status);
		ocorrencias.add(oc3);
		
		Aluno a2 = new AlunoRepository().getAlunobyMatricula("20191148060004");
		Ocorrencia oc4 = new Ocorrencia("Perda de material", "Perdeu a chave do seu armário pessoal", a2, status);
		ocorrencias.add(oc4);
		
		Aluno a3 = new AlunoRepository().getAlunobyMatricula("20201148060022");
		Ocorrencia oc5 = new Ocorrencia("Falta de uniforme", "Veio à escola sem a blusa do fardamento", a3, status);
		ocorrencias.add(oc5);
		
		contador += 5;
	}
	
	
	
	public void save( Ocorrencia ocorrencia ) {
		contador += 1;
		ocorrencia.setId(contador);
		this.ocorrencias.add(ocorrencia);
		
		System.out.println("contador: " + contador);
		System.out.println("ocorrencia: " + ocorrencia.getId());
	}
	
	public List<Ocorrencia> getAllOcorrencias( ) {
		return ocorrencias;
	}
	
	public Ocorrencia findById( int id ) {
		Ocorrencia ocorrencia = new Ocorrencia();
		
		for (Ocorrencia oc : ocorrencias) {
			if (oc.getId() == id) { ocorrencia = oc; }
		}
		//System.out.println("codigo: " + turma.getCodigo());
		return ocorrencia;
		
		
	}

	public String getData() {
		//Ocorrencia ocorrencia = findById(index);
		//System.out.println("DATA-HORA: " + ocorrencia.getDataHora());
		
		//Calendar dataHora = ocorrencia.getDataHora();
		/*
		int ano = dataHora.get(Calendar.YEAR);
		int mes = dataHora.get(Calendar.MONTH);
		int dia = dataHora.get(Calendar.DAY_OF_MONTH);
		int hora = dataHora.get(Calendar.HOUR_OF_DAY);
		int minutos = dataHora.get(Calendar.MINUTE);
		int segundos = dataHora.get(Calendar.SECOND);
		
		return (dia + "/" + mes + "/" + ano + " " + hora + ":" + minutos + ":" + segundos);
		*/
		return "DD-MM-AAA";
	}

	
	public int size() {
		return ocorrencias.size();
	}
	
	
	
}
