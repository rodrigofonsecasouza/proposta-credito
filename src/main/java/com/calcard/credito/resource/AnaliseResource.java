package com.calcard.credito.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calcard.credito.bean.Proposta;
import com.calcard.credito.repository.PropostaRepository;
import com.calcard.credito.service.AnaliseCreditoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST de Análise de Crédito")
@RestController
@RequestMapping("analise")
public class AnaliseResource {

	@Autowired
	private PropostaRepository propostaRepository;
	@Autowired
	private AnaliseCreditoService service;

	@ApiOperation(value = "Processa a análise de crédito da proposta")
	@PutMapping("/{id}")
	public void analisarCredito(@PathVariable("id") final Long id, @RequestBody final Proposta proposta) {
		service.analiseCredito(proposta);
		propostaRepository.save(proposta);
	}

}
