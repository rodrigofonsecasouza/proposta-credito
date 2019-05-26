package com.calcard.credito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.calcard.credito.bean.Proposta;
import com.calcard.credito.enums.ResultadoAnaliseCredito;
import com.calcard.credito.repository.PropostaRepository;

@Component
public class InsertCommandLineRunner implements CommandLineRunner {

	@Autowired
	private PropostaRepository propostaRepository;

	@Override
	public void run(String... args) throws Exception {
		propostaRepository.save(new Proposta("Rodrigo Fonseca de Souza", "000.000.000-10", 24, 'M', "Casado(a)", "SC",
				0, 1200d, ResultadoAnaliseCredito.EM_FILA_DE_PROCESSAMENTO));
		propostaRepository.save(new Proposta("João da Silva", "000.000.000-10", 24, 'M', "Solteiro", "SC",
				0, 2000d, ResultadoAnaliseCredito.EM_FILA_DE_PROCESSAMENTO));
	}

}
