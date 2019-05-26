package com.calcard.credito.service;

import org.springframework.stereotype.Service;

import com.calcard.credito.bean.Proposta;
import com.calcard.credito.enums.LimiteCredito;
import com.calcard.credito.enums.ResultadoAnaliseCredito;

@Service
public class AnaliseCreditoService {

	private static final int REPROVADO = 100;
	private static final int ENTRE_100_500 = 300;
	private static final int ENTRE_500_1000 = 500;
	private static final int ENTRE_1000_1500 = 700;
	private static final int ENTRE_1500_2000 = 900;
	private static final int ACIMA_2000 = 1000;

	public void analiseCredito(Proposta proposta) {
		if (proposta.getRenda() <= 500) {
			proposta.setResultado(ResultadoAnaliseCredito.NEGADO);
			proposta.setLimite(LimiteCredito.RENDA_BAIXA);
		} else {
			int score = 0;
			// renda
			score = verificaRenda(proposta.getRenda());
			// idade
			if (proposta.getIdade() <= 25) {
				score += 50;
			} else {
				score += 100;
			}
			// dependentes
			if (proposta.getDependentes() > 0) {
				score -= (proposta.getDependentes() * 100);
			}
			verificaResultado(proposta, score);
		}

	}

	private int verificaRenda(Double renda) {
		int score;
		if (renda <= 1000) {
			score = 100;
		} else if (renda <= 2000) {
			score = 300;
		} else if (renda <= 3000) {
			score = 500;
		} else if (renda <= 6000) {
			score = 700;
		} else {
			score = 900;
		}
		return score;
	}

	private void verificaResultado(Proposta proposta, int score) {

		if (score <= REPROVADO) {
			proposta.setLimite(LimiteCredito.REPROVADO_POLITICA_CREDITO);
			proposta.setResultado(ResultadoAnaliseCredito.NEGADO);
		} else if (score <= ENTRE_100_500) {
			proposta.setLimite(LimiteCredito.ENTRE_100_500);
			proposta.setResultado(ResultadoAnaliseCredito.APROVADO);
		} else if (score <= ENTRE_500_1000) {
			proposta.setLimite(LimiteCredito.ENTRE_500_1000);
			proposta.setResultado(ResultadoAnaliseCredito.APROVADO);
		} else if (score <= ENTRE_1000_1500) {
			proposta.setLimite(LimiteCredito.ENTRE_1000_1500);
			proposta.setResultado(ResultadoAnaliseCredito.APROVADO);
		} else if (score <= ENTRE_1500_2000) {
			proposta.setLimite(LimiteCredito.ENTRE_1500_2000);
			proposta.setResultado(ResultadoAnaliseCredito.APROVADO);
		} else {
			proposta.setLimite(LimiteCredito.SUPERIOR_2000);
			proposta.setResultado(ResultadoAnaliseCredito.APROVADO);
		}
	}

}
