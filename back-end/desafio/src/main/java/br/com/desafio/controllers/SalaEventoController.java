package br.com.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.models.SalaEventoEntity;
import br.com.desafio.services.SalaEventoService;
@CrossOrigin
@RestController
@RequestMapping("/sala-evento")
public class SalaEventoController {

	@Autowired
	private SalaEventoService salaEventoService;
	
	/**
	 * Retorna uma lista de Salas de Eventos cadastradas no Banco de Dados.
	 * @return List de SalaEventoEntity
	 */

	@GetMapping
	public List<SalaEventoEntity>getListaSala(){
		return this.salaEventoService.getListaSalaEvento();
}

	/**
	 * Cadastra uma Sala de Eventos com base em um JSON enviado via POST.
	 * 
	 * @param salaEventoEntity
	 * @return EspacoCafeEntity que foi cadastrado.
	 */
	@PostMapping
	public SalaEventoEntity addSalaEvento(@RequestBody SalaEventoEntity salaEventoEntity) {
		return this.salaEventoService.save(salaEventoEntity);
	}
}
