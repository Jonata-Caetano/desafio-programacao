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

import br.com.desafio.models.PessoasEntity;
import br.com.desafio.repositories.PessoasRepository;
import br.com.desafio.services.PessoasService;

@ExtendWith(SpringExtension.class)
public class PessoasServiceTest {
	
	/**
	 * Injeta um objeto repository que será gerenciado pelo mockito
	 */
	@Mock
	private PessoasRepository mockPessoasRepository;

	/**
	 * Injeta um objeto service que será gerenciado pelo mockito juntamente com os mocks necessários
	 */
	@InjectMocks
	private PessoasService pessoasService;

	@Test
	void deveRetornarUmaPessoasNoBanco() {
		// Arrange
		/**
		 * Monta um mock de EspacoEntity para evitar acesso ao banco de dados.
		 */
		final List<PessoasEntity> mockPessoasEntityList = new ArrayList<PessoasEntity>() {{
			add(new PessoasEntity(1, "Joao","da Rosa"));
			add(new PessoasEntity(2, "Marcos","Macedo"));
		}};

		
		/**
		 * Faz o mock da consulta ao banco de dados com base na lista pré-montada.
		 */
		when(mockPessoasRepository.findAll()).thenReturn(mockPessoasEntityList);

		// Act
		List<PessoasEntity> pessoasEntityList = pessoasService.getListaPessoas();

		// Assert
		/**
		 * Garante que o acesso ao banco de dados seja feito apenas uma unica vez.
		 */
		verify(mockPessoasRepository).findAll();
		/**
		 * A quantidade da lista retornada deva ser a mesma que foi mockada
		 */
		assertEquals(pessoasEntityList.size(), mockPessoasEntityList.size());
		/**
		 * Os dados que foram mockados devem ser os mesmos que foram mockados
		 */
		assertEquals(pessoasEntityList.get(0).getId(), mockPessoasEntityList.get(0).getId());
		assertEquals(pessoasEntityList.get(0).getNome(), mockPessoasEntityList.get(0).getNome());
		assertEquals(pessoasEntityList.get(0).getSobrenome(), mockPessoasEntityList.get(0).getSobrenome());
		assertEquals(pessoasEntityList.get(1).getId(), mockPessoasEntityList.get(1).getId());
		assertEquals(pessoasEntityList.get(1).getNome(), mockPessoasEntityList.get(1).getNome());
		assertEquals(pessoasEntityList.get(1).getSobrenome(), mockPessoasEntityList.get(1).getSobrenome());
	}

	@Test
	void deveSalvarUmaPessoNoBanco() {
		// Arrange
		/**
		 * Faz um mock do espaco que será enviado para o banco.
		 */
		final PessoasEntity mockPessoasEntity = new PessoasEntity(3, "Jonata","Cardoso");

		/**
		 * Realiza o mock para quando a chamada for feita ao banco, retorne o mock feito.
		 */
		when(mockPessoasRepository.save(any())).thenReturn(mockPessoasEntity);

		// Act
		PessoasEntity newPessoasEntity = pessoasService.save(new PessoasEntity(3, "Jonata","Cardoso"));

		// Assert
		/**
		 * Realiza a conferência de todo os dados para verificar se está tudo igual.
		 */
		assertNotNull(newPessoasEntity);
		assertEquals(newPessoasEntity.getId(), mockPessoasEntity.getId());
		assertEquals(newPessoasEntity.getNome(), mockPessoasEntity.getNome());
		assertEquals(newPessoasEntity.getSobrenome(), mockPessoasEntity.getSobrenome());
		verify(mockPessoasRepository).save(any());
	}

}
