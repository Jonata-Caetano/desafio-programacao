package br.com.desafio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.desafio.models.EspacoCafeEntity;
import br.com.desafio.repositories.EspacoCafeRepository;
import br.com.desafio.services.EspacoCafeService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class EspacoCafeServiceTest {

	/**
	 * Injeta um objeto repository que será gerenciado pelo mockito
	 */
	@Mock
	private EspacoCafeRepository mockEspacoRepository;

	/**
	 * Injeta um objeto service que será gerenciado pelo mockito juntamente com os mocks necessários
	 */
	@InjectMocks
	private EspacoCafeService espacoService;

	@Test
	void deveRetornarUmaListaDeEspacoes() {
		// Arrange
		/**
		 * Monta um mock de EspacoEntity para evitar acesso ao banco de dados.
		 */
		final List<EspacoCafeEntity> mockEspacoEntityList = new ArrayList<EspacoCafeEntity>() {{
			add(new EspacoCafeEntity(1, "Cafeteria",25));
			add(new EspacoCafeEntity(2, "Auditorio",25));
		}};

		/**
		 * Faz o mock da consulta ao banco de dados com base na lista pré-montada.
		 */
		when(mockEspacoRepository.findAll()).thenReturn(mockEspacoEntityList);

		// Act
		List<EspacoCafeEntity> espacoEntityList = espacoService.getListaEspacosCafe();

		// Assert
		/**
		 * Garante que o acesso ao banco de dados seja feito apenas uma unica vez.
		 */
		verify(mockEspacoRepository).findAll();
		/**
		 * A quantidade da lista retornada deva ser a mesma que foi mockada
		 */
		assertEquals(espacoEntityList.size(), mockEspacoEntityList.size());
		/**
		 * Os dados que foram mockados devem ser os mesmos que foram mockados
		 */
		assertEquals(espacoEntityList.get(0).getId(), mockEspacoEntityList.get(0).getLotacao());
		assertEquals(espacoEntityList.get(0).getNome(), mockEspacoEntityList.get(0).getNome());
		assertEquals(espacoEntityList.get(1).getId(), mockEspacoEntityList.get(1).getId());
		assertEquals(espacoEntityList.get(1).getNome(), mockEspacoEntityList.get(1).getNome());
	}

	@Test
	void deveSalvarUmEspacoNoBanco() {
		// Arrange
		/**
		 * Faz um mock do espaco que será enviado para o banco.
		 */
		final EspacoCafeEntity mockEspacoEntity = new EspacoCafeEntity(3, "Area de lazer",25);

		/**
		 * Realiza o mock para quando a chamada for feita ao banco, retorne o mock feito.
		 */
		when(mockEspacoRepository.save(any())).thenReturn(mockEspacoEntity);

		// Act
		EspacoCafeEntity newEspacoEntity = espacoService.save(new EspacoCafeEntity(3, "Area de lazer",25));

		// Assert
		/**
		 * Realiza a conferência de todo os dados para verificar se está tudo igual.
		 */
		assertNotNull(newEspacoEntity);
		assertEquals(newEspacoEntity.getId(), mockEspacoEntity.getId());
		assertEquals(newEspacoEntity.getNome(), mockEspacoEntity.getNome());
		verify(mockEspacoRepository).save(any());
	}

}
