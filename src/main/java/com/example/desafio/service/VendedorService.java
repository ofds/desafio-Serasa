package com.example.desafio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.entity.Atuacao;
import com.example.desafio.entity.Vendedor;
import com.example.repository.IVendedorRepository;

import view.VendedorView;

@Service
public class VendedorService implements IVendedorService {

	@Autowired
	private IVendedorRepository vendedorRepository;
	
	@Autowired
	AtuacaoService atuacaoService;

	public boolean save(Vendedor vendedor) {
		System.out.println("VendedorService: Inserindo vendedor");
		System.out.println("Nome:" + vendedor.getNome());
		System.out.println("telefone:" + vendedor.getNome());
		System.out.println("Idade" + vendedor.getIdade());
		System.out.println("Cidade" + vendedor.getCidade());
		System.out.println("Estado" + vendedor.getEstado());
		System.out.println("Regiao" + vendedor.getRegiao());
		try {
			vendedor = vendedorRepository.save(vendedor);
			System.out.println("\n\nVendedorService: Vendedor inserido");
		} catch (Exception e) {
			System.out.println("\n\nVendedorService: Problemas na insercao do vendedor");
			return false;
		}
		return true;
	}

	public List<VendedorView> findAll() {
		System.out.println("VendedorService: Procurando todos os vendedores ");

		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		

		try {
			vendedores = vendedorRepository.findAll();
		} catch (Exception e) {
			System.out.println("\n\nVendedorService: Problemas na busca de vendedores");
		}

		List<VendedorView> vendedoresView = new ArrayList<VendedorView>();
		vendedores.forEach((temp) -> {
			vendedoresView.add(new VendedorView(temp,atuacaoService.findById(temp.getRegiao()).get()));
        });
		
		
		return vendedoresView;
	}

	public VendedorView findById(Long id){
		Optional<Vendedor> vendedor = Optional.empty();
		vendedor = vendedorRepository.findById(id);
		if (vendedor.isEmpty()) {
			System.out.println("\n\nVendedorService: Vendedor nao encontrado");
			return null;
		}
		
		Optional<Atuacao> atuacao = atuacaoService.findById(vendedor.get().getRegiao());
		if (atuacao == null) {
			System.out.println("\n\nVendedorService: atuacao nao encontrada");
			return null;
		}
		
		VendedorView vendedorView = new VendedorView(vendedor.get(),atuacao.get());
		return vendedorView;
	}

}
