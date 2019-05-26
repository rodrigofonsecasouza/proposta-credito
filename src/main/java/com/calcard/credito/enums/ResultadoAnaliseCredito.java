package com.calcard.credito.enums;

public enum ResultadoAnaliseCredito {
	EM_FILA_DE_PROCESSAMENTO("Em fila de processamento"), APROVADO("Aprovado"), NEGADO("Negado");

	private final String valor;

	ResultadoAnaliseCredito(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}
