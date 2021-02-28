package br.com.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.models.SalaEventoEntity;
import br.com.desafio.repositories.SalaEventoRepository;

@Service
public class SalaEventoService {
	@Autowired
	private SalaEventoRepository salaEventoRepository;
	
	/**
	 * Pega do banco de dados uma lista de Sala de Eventos.
	 * 
	 * @return List de SalaEventoEntity
	 */
	
	public List<SalaEventoEntity> getListaSalaEvento(){
		return salaEventoRepository.findAll();
	}
	
	/** 
	 * Salvo no Banco de Dados uma Entidade que foi enviada através da Controller.
	 * @param salaEvento
	 * @return SalaEventoEntity
	 */
	public SalaEventoEntity save (SalaEventoEntity salaEvento) {
		return salaEventoRepository.save(salaEvento);
	}
	
}
