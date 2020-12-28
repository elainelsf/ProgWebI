package com.ifrn.ocorrenciasElaineRaquel.model;


public enum StatusOcorrencia {
	CADASTRADA(1),
	ANALISE(2),
	CANCELADA(3),
	RESOLVIDA(4);

	private int status;
	
	StatusOcorrencia(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
	
	/*public void consultarStatus() {
		for (StatusOcorrencia status : StatusOcorrencia.values()) {
		      System.out.println(status.getStatus());
		  }
	}*/
}
