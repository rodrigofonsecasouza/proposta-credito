package com.calcard.credito.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.calcard.credito.bean.Proposta;
import com.calcard.credito.enums.ResultadoAnaliseCredito;

public interface PropostaRepository extends CrudRepository<Proposta, Long> {

	List<Proposta> findByCpf(String cpf);
	
	List<Proposta> findByResultado(ResultadoAnaliseCredito resultado);
}
