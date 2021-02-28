package br.com.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.desafio.models.PessoasEntity;

/**
 * Utilizado JpaRepository para facilitar as operações ao Banco de Dados.
 */
public interface PessoasRepository extends JpaRepository<PessoasEntity, Integer> {

}
