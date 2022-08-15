package com.example.desafio.service;

import java.util.Optional;

import com.example.desafio.model.Atuacao;

public interface IAtuacaoService {

	
	public boolean save(Atuacao atuacao);
	
	public Optional<Atuacao> findById(String regiao);
}
