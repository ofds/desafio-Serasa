package com.example.desafio.service;

import java.util.Optional;

import com.example.desafio.entity.Atuacao;

public interface IAtuacaoService {

	
	public boolean save(Atuacao atuacao);
	
	public Optional<Atuacao> findById(String regiao);
}
