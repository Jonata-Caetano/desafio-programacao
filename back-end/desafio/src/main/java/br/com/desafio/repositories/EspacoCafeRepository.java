package br.com.desafio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.models.EspacoCafeEntity;

/**
 * Utilizado JpaRepository para facilitar as operações ao Banco de Dados.
 */

@Repository
public interface EspacoCafeRepository  extends JpaRepository<EspacoCafeEntity, Integer>{

}
