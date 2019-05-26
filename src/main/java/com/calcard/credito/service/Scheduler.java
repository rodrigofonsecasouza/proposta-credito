package com.calcard.credito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.calcard.credito.bean.Proposta;
import com.calcard.credito.enums.ResultadoAnaliseCredito;
import com.calcard.credito.repository.PropostaRepository;

@Component
@EnableScheduling
public class Scheduler {

	@Autowired
	private PropostaRepository propostaRepository;
	@Autowired
	private AnaliseCreditoService service;

	private final long SEGUNDO = 1000;
	private final long MINUTO = SEGUNDO * 60;

	@Scheduled(fixedDelay = MINUTO)
	public void analiseCredito() {
		List<Proposta> propostasAnalisar = propostaRepository
				.findByResultado(ResultadoAnaliseCredito.EM_FILA_DE_PROCESSAMENTO);
		propostasAnalisar.forEach(prop -> {
			service.analiseCredito(prop);
			propostaRepository.save(prop);
		});
	}

}
