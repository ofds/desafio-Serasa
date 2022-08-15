package com.example.desafio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
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
import com.example.desafio.model.Vendedor;
import com.example.desafio.service.AtuacaoService;
import com.example.desafio.service.VendedorService;
import com.example.repository.IAtuacaoRepository;
import com.example.repository.IVendedorRepository;

import view.VendedorView;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class VendedorServiceTests {

	@InjectMocks
	VendedorService vendedorService;
	
	@Mock
	IVendedorRepository vendedorRepository;
	
	@Mock
	AtuacaoService atuacaoService;
	
	String regiao = "Sudeste";
	List<String> estados = Arrays.asList("RJ","SP","ES","MG");

	
	@Test
	public void saveTest()
	{
		Vendedor mockVendedor = new Vendedor("Fulano de Tal","99 99999-9999", 99, "Cidade de Fulano", "MG","Sudeste");
		Vendedor mockVendedor2 = new Vendedor("Fulana da Silva","99 99439-9949", 99, "Cidade de Fulana", "SP","Sudeste");
		
		boolean success = vendedorService.save(mockVendedor);
		boolean success2 = vendedorService.save(mockVendedor2);
		
		verify(vendedorRepository, times(1)).save(mockVendedor);
		verify(vendedorRepository, times(1)).save(mockVendedor2);
		assertTrue(success);
		assertTrue(success2);
		
		
	}
	
	@Test
	public void findAllTest()
	{
		Vendedor mockVendedor = new Vendedor("Fulano de Tal","99 99999-9999", 99, "Cidade de Fulano", "MG","Sudeste");
		Vendedor mockVendedor2 = new Vendedor("Fulana da Silva","99 99439-9949", 99, "Cidade de Fulana", "SP","Sudeste");
		List<Vendedor> mockVendedores = new ArrayList<Vendedor>(Arrays.asList(mockVendedor,mockVendedor2));
		Atuacao atuacao = new Atuacao(regiao,estados);
		when(atuacaoService.findById(regiao)).thenReturn(Optional.of(atuacao));
		when(vendedorRepository.findAll()).thenReturn(mockVendedores);
		
		
		List<VendedorView> vendedoresView = vendedorService.findAll();
		
		
		verify(vendedorRepository, times(1)).findAll();
		assertTrue(vendedoresView.size()==2);
		assertEquals(vendedoresView.get(0).getNome(), "Fulano de Tal");
		assertEquals(vendedoresView.get(1).getNome(), "Fulana da Silva");
		
	}
	
	@Test
	public void findByIdTest()
	{
		
		Vendedor mockVendedor = new Vendedor("Fulano de Tal","99 99999-9999", 99, "Cidade de Fulano", "MG","Sudeste");
		Vendedor mockVendedor2 = new Vendedor("Fulana da Silva","99 99439-9949", 99, "Cidade de Fulana", "SP","Sudeste");
		Atuacao atuacao = new Atuacao(regiao,estados);
		when(atuacaoService.findById(regiao)).thenReturn(Optional.of(atuacao));
		when(vendedorRepository.findById((long) 0)).thenReturn(Optional.of(mockVendedor));
		when(vendedorRepository.findById((long) 1)).thenReturn(Optional.of(mockVendedor2));
		when(vendedorRepository.findById((long) 2)).thenReturn(Optional.empty());
		
		VendedorView vendedorView0 = vendedorService.findById((long) 0);
		VendedorView vendedorView1 = vendedorService.findById((long) 1);
		VendedorView vendedorView2 = vendedorService.findById((long) 2);
		
		assertEquals(vendedorView0.getNome(), "Fulano de Tal");
		assertEquals(vendedorView1.getNome(), "Fulana da Silva");
		assertNull(vendedorView2);
		
	}
	
}
