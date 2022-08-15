package com.example.desafio;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.desafio.model.Atuacao;
import com.example.desafio.service.AtuacaoService;
import com.example.repository.IAtuacaoRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AtuacaoServiceTests {
	
	@InjectMocks
	AtuacaoService atuacaoService;
	
	@Mock
	IAtuacaoRepository atuacaoRepository;
	
	String regiao = "Sudeste";
	List<String> estados = Arrays.asList("RJ","SP","ES","MG");
	
	@Test
	public void saveTest()
	{
		Atuacao atuacao = new Atuacao(regiao,estados);

		boolean success = atuacaoService.save(atuacao);

		verify(atuacaoRepository, times(1)).save(atuacao);
		assertTrue(success);
	}
	
	@Test
	public void findByIdTest()
	{
		Atuacao atuacao = new Atuacao(regiao,estados);
		when(atuacaoRepository.findById(regiao)).thenReturn(Optional.of(atuacao));
		
		Optional<Atuacao> atuacaoReturned = atuacaoRepository.findById(regiao);
		
		assertEquals(regiao, atuacaoReturned.get().getRegiao());
		assertEquals(estados, atuacaoReturned.get().getEstados());
	}

}
