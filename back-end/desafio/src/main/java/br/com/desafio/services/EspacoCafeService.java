package br.com.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.models.EspacoCafeEntity;
import br.com.desafio.repositories.EspacoCafeRepository;

@Service
public class EspacoCafeService {
	@Autowired
	private EspacoCafeRepository espacoCafeRepository;

	/**
	 * Pega do Banco de Dados uma lista de Espaços Café.
	 * 
	 * @return List de EspacoCafeEntity
	 */
	public List<EspacoCafeEntity> getListaEspacosCafe() {
		return espacoCafeRepository.findAll();
	}
	
	/** 
	 * Salvo no Banco de Dados uma Entidade que foi enviada do Controller.
	 * @param espacoCafe
	 * @return EspacoCafeEntity
	 */

	public EspacoCafeEntity save(EspacoCafeEntity espacoCafe) {
		return espacoCafeRepository.save(espacoCafe);
	}
}
