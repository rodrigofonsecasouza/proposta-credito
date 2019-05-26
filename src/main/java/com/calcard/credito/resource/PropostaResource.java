package com.calcard.credito.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.calcard.credito.bean.Proposta;
import com.calcard.credito.enums.ResultadoAnaliseCredito;
import com.calcard.credito.repository.PropostaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST de Propostas")
@RestController
@RequestMapping("propostas")
public class PropostaResource {

	@Autowired
	private PropostaRepository propostaRepository;

	@ApiOperation(value = "Retorna uma lista de Propostas")
	@GetMapping
	public List<Proposta> findAllPropostas() {
		return (List<Proposta>) this.propostaRepository.findAll();
	}

	@ApiOperation(value = "Retorna a Proposta cadastrada para o CPF")
	@GetMapping("/{cpf}")
	public List<Proposta> findByCpf(@PathVariable("cpf") final String cpf) {
		return (List<Proposta>) this.propostaRepository.findByCpf(cpf);
	}

	@ApiOperation(value = "Salva uma Proposta")
	@PostMapping
	public ResponseEntity<Proposta> save(@RequestBody final Proposta proposta) {
		proposta.setResultado(ResultadoAnaliseCredito.EM_FILA_DE_PROCESSAMENTO);
		final Proposta newProposta = this.propostaRepository.save(proposta);

		final URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newProposta.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
}
