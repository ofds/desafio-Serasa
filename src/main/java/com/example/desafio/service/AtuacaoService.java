package com.example.desafio.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.model.Atuacao;
import com.example.repository.IAtuacaoRepository;

@Service
public class AtuacaoService implements IAtuacaoService {

	
	@Autowired
	IAtuacaoRepository atuacaoRepository;
	
	@Override
	public boolean save(Atuacao atuacao) {
		try {
			atuacao = atuacaoRepository.save(atuacao);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Optional<Atuacao> findById(String regiao) {
		return atuacaoRepository.findById(regiao);
	}

}
