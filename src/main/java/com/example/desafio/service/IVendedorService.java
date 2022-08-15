package com.example.desafio.service;

import java.util.List;

import com.example.desafio.model.Vendedor;

import view.VendedorView;

public interface IVendedorService {
	
	
	public boolean save(Vendedor vendedor);
	
	public List<VendedorView> findAll();

	public VendedorView findById(Long id);

}
