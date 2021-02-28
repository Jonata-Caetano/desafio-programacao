package br.com.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.models.EspacoCafeEntity;
import br.com.desafio.services.EspacoCafeService;
@CrossOrigin
@RestController
@RequestMapping("/espaco-cafe")
public class EspacoCafeController {

	@Autowired
	private EspacoCafeService espacoCafeService;
	
	/**
	 * Retorna uma lista de Espacos de Café cadastras no Banco de Dados.
	 * @return List de EspacoCafeEntity
	 */

	@GetMapping
	public List<EspacoCafeEntity> getListaEspacosCafe() {
		return this.espacoCafeService.getListaEspacosCafe();
	}

	/** 
	 * Cadastra um Espaco de Cafe com base em um JSON enviado via POST.
	 * 
	 * @param espacoCafeEntity
	 * @return EspacoCafeEntity que foi cadastrado.
	 */
	@PostMapping
	public EspacoCafeEntity addEspacoCafe(@RequestBody EspacoCafeEntity espacoCafeEntity) {
		return this.espacoCafeService.save(espacoCafeEntity);
		

	}
}
