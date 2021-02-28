package br.com.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.models.PessoasEntity;
import br.com.desafio.repositories.PessoasRepository;

@Service
public class PessoasService {
	@Autowired
	private PessoasRepository pessoasRepository;

	/**
	 * Pega do Banco de Dados uma lista de Pessoas.
	 * 
	 * @return List de PessoasEntity
	 */
	public List<PessoasEntity> getListaPessoas() {
		return pessoasRepository.findAll();
	}
	
	/**
	 * Salvo no Banco de Dados uma Entidade que foi enviada da Controller
	 * @param pessoas
	 * @return PessoasEntity
	 */

	public PessoasEntity save(PessoasEntity pessoas) {
		return pessoasRepository.save(pessoas);
	}

}
