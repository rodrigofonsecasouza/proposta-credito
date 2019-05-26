package com.calcard.credito.bean;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.calcard.credito.enums.LimiteCredito;
import com.calcard.credito.enums.ResultadoAnaliseCredito;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cpf;
	private Integer idade;
	private char sexo;
	private String estadoCivil;
	private String estado;
	private Integer dependentes;
	private Double renda;
	private ResultadoAnaliseCredito resultado;
	private LimiteCredito limite;

	public Proposta() {

	}

	public Proposta(String nome, String cpf, Integer idade, char sexo, String estadoCivil, String estado,
			Integer dependentes, Double renda, ResultadoAnaliseCredito resultado) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.estado = estado;
		this.dependentes = dependentes;
		this.renda = renda;
		this.resultado = resultado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getDependentes() {
		return dependentes;
	}

	public void setDependentes(Integer dependentes) {
		this.dependentes = dependentes;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public ResultadoAnaliseCredito getResultado() {
		return resultado;
	}

	public void setResultado(ResultadoAnaliseCredito resultado) {
		this.resultado = resultado;
	}

	public LimiteCredito getLimite() {
		return limite;
	}

	public void setLimite(LimiteCredito limite) {
		this.limite = limite;
	}

}
