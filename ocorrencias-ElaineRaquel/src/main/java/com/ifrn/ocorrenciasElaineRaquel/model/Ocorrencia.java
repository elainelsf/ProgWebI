package com.ifrn.ocorrenciasElaineRaquel.model;

import java.util.Calendar;

public class Ocorrencia {
	
	private int id;
	private String titulo;
	private String descricao;
	private Calendar dataHora;
	private Aluno aluno;
	private StatusOcorrencia status;
	
	public Ocorrencia() {
		super();
	}

	public Ocorrencia(String titulo, String descricao, Aluno aluno, StatusOcorrencia status) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.aluno = aluno;
		this.status = status;
		
		Calendar c = Calendar.getInstance();
		this.dataHora = c;
		
		/*
		System.out.println("Data/Hora atual: "+c.getTime());
		System.out.println("Ano: "+c.get(Calendar.YEAR));
		System.out.println("Mês: "+c.get(Calendar.MONTH));
		System.out.println("Dia do Mês: "+c.get(Calendar.DAY_OF_MONTH));
		*/
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public StatusOcorrencia getStatus() {
		return status;
	}

	public void setStatus(StatusOcorrencia status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Ocorrencia [titulo=" + titulo + ", descricao=" + descricao + ", dataHora=" + dataHora + ", aluno="
				+ aluno + ", status=" + status + "]";
	}
}
