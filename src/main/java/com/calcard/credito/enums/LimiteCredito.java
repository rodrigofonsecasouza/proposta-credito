package com.calcard.credito.enums;

public enum LimiteCredito {
	
	ENTRE_100_500("entre 100 - 500"),
	ENTRE_500_1000("entre 500 - 1000"),
	ENTRE_1000_1500("entre 1000 - 1500"),
	ENTRE_1500_2000("entre 1500 - 2000"),
	SUPERIOR_2000("superior 2000"),
	REPROVADO_POLITICA_CREDITO("Reprovado pela política de crédito"),
	RENDA_BAIXA("renda baixa"); 
	
	private final String valor;

	LimiteCredito(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
