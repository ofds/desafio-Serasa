package com.example.desafio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.model.Atuacao;
import com.example.desafio.model.Vendedor;
import com.example.repository.IVendedorRepository;

import view.VendedorView;

@Service
public class VendedorService implements IVendedorService {

	@Autowired
	private IVendedorRepository vendedorRepository;

	@Autowired
	AtuacaoService atuacaoService;

	@Override
	public boolean save(Vendedor vendedor) {
		
		try {
			vendedor = vendedorRepository.save(vendedor);
		} catch (Exception e) {
			return false;
		}
		return true;
		
	}

	@Override
	public List<VendedorView> findAll() {
		List<Vendedor> vendedores = new ArrayList<Vendedor>();

		try {
			vendedores = vendedorRepository.findAll();
		} catch (Exception e) {
		}
		List<VendedorView> vendedoresView = new ArrayList<VendedorView>();
		if (!vendedores.isEmpty()) {
			vendedores.forEach((temp) -> {
				vendedoresView.add(new VendedorView(temp, atuacaoService.findById(temp.getRegiao()).get()));
			});
		}
		return vendedoresView;
		
	}

	@Override
	public VendedorView findById(Long id) {
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

		VendedorView vendedorView = new VendedorView(vendedor.get(), atuacao.get());
		return vendedorView;
	}

}
