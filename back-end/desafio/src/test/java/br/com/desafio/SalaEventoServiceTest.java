package br.com.desafio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.desafio.models.SalaEventoEntity;
import br.com.desafio.repositories.SalaEventoRepository;
import br.com.desafio.services.SalaEventoService;


@ExtendWith(SpringExtension.class)
public class SalaEventoServiceTest {
	/**
	 * Injeta um objeto repository que será gerenciado pelo mockito
	 */
	@Mock
	private SalaEventoRepository mockEventoRepository;

	/**
	 * Injeta um objeto service que será gerenciado pelo mockito juntamente com os mocks necessários
	 */
	@InjectMocks
	private SalaEventoService eventoService;

	@Test
	void deveRetornarUmaListaDeSalasEvento() {
		// Arrange
		/**
		 * Monta um mock de EspacoEntity para evitar acesso ao banco de dados.
		 */
		final List<SalaEventoEntity> mockEventoEntityList = new ArrayList<SalaEventoEntity>() {{
			add(new SalaEventoEntity(1, "Sala",25));
			add(new SalaEventoEntity(2, "Recepcao",25));
		}};

		/**
		 * Faz o mock da consulta ao banco de dados com base na lista pré-montada.
		 */
		when(mockEventoRepository.findAll()).thenReturn(mockEventoEntityList);

		// Act
		List<SalaEventoEntity> eventoEntityList = eventoService.getListaSalaEvento();

		// Assert
		/**
		 * Garante que o acesso ao banco de dados seja feito apenas uma unica vez.
		 */
		verify(mockEventoRepository).findAll();
		/**
		 * A quantidade da lista retornada deva ser a mesma que foi mockada
		 */
		assertEquals(eventoEntityList.size(), mockEventoEntityList.size());
		/**
		 * Os dados que foram mockados devem ser os mesmos que foram mockados
		 */
		assertEquals(eventoEntityList.get(0).getId(), mockEventoEntityList.get(0).getId());
		assertEquals(eventoEntityList.get(0).getNome(), mockEventoEntityList.get(0).getNome());
		assertEquals(eventoEntityList.get(0).getLotacao(), mockEventoEntityList.get(0).getLotacao());
		assertEquals(eventoEntityList.get(1).getId(), mockEventoEntityList.get(1).getId());
		assertEquals(eventoEntityList.get(1).getNome(), mockEventoEntityList.get(1).getNome());
		assertEquals(eventoEntityList.get(1).getLotacao(), mockEventoEntityList.get(1).getLotacao());
	}

	@Test
	void deveSalvarUmSalaEventoNoBanco() {
		// Arrange
		/**
		 * Faz um mock do espaco que será enviado para o banco.
		 */
		final SalaEventoEntity mockEventoEntity = new SalaEventoEntity(3, "Area de Curso",25);

		/**
		 * Realiza o mock para quando a chamada for feita ao banco, retorne o mock feito.
		 */
		when(mockEventoRepository.save(any())).thenReturn(mockEventoEntity);

		// Act
		SalaEventoEntity newEventoEntity = eventoService.save(new SalaEventoEntity(3, "Area de Curso",25));

		// Assert
		/**
		 * Realiza a conferência de todo os dados para verificar se está tudo igual.
		 */
		assertNotNull(newEventoEntity);
		assertEquals(newEventoEntity.getId(), mockEventoEntity.getId());
		assertEquals(newEventoEntity.getNome(), mockEventoEntity.getNome());
		assertEquals(newEventoEntity.getLotacao(), mockEventoEntity.getLotacao());
		verify(mockEventoRepository).save(any());
	}

}



