package br.com.desafio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthcheck")
public class HealthCheckController {
	
	/**
	 * Retorna se o status da aplicação está no ar.
	 * @return a string com a descrição que está no ar.
	 */

	@GetMapping
	public String getHealhCheck() {
		return "A aplicação está no ar!";
	}
}
