package br.com.desafio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.models.PessoasEntity;
import br.com.desafio.services.PessoasService;
@CrossOrigin
@RestController
@RequestMapping("/pessoa")
public class PessoasController {

	@Autowired
	private PessoasService pessoasService;

	/**
	 * Retorna uma lista de Pessoas cadastradas no Banco de Dados.
	 * @return List de PessoasEntity.
	 */
	@GetMapping
	public List<PessoasEntity> getListaPessoas() {
		return this.pessoasService.getListaPessoas();
	}
	
	/**
	 * Cadastra uma Pessoa com base em um JSON enviado via POST.
	 * @param pessoasEntity
	 * @return PessoasEntity que foi cadastrado.
	 */
	@PostMapping
	public PessoasEntity addPessoas(@RequestBody PessoasEntity pessoasEntity) {
		return this.pessoasService.save(pessoasEntity);
	}
}
