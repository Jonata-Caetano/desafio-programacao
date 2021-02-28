package br.com.desafio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Utilizado as anotações do Lombok para reduzir boilerplate na aplicação.
 * @author Windows
 *
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name= "sala_evento")
public class SalaEventoEntity {

	@Id
	@Column
	private Integer id;
	
	@Column
	private String nome;
	
	@Column
	private Integer lotacao;
}
