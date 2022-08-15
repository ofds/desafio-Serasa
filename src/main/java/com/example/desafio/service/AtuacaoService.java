package com.example.desafio.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.entity.Atuacao;
import com.example.repository.IAtuacaoRepository;

@Service
public class AtuacaoService implements IAtuacaoService {

	
	@Autowired
	IAtuacaoRepository atuacaoRepository;
	
	@Override
	public boolean save(Atuacao atuacao) {
		System.out.println("AtuacaoService: Inserindo Atuacao");
		System.out.println("Regiao: "+ atuacao.getRegiao());
		System.out.println("Estados"+ atuacao.getEstados());
		try {
			atuacao = atuacaoRepository.save(atuacao);
			System.out.println("\n\nAtuacaoService: Atuacao inserido, id:" + atuacao.getRegiao());
		} catch (Exception e) {
			System.out.println("\n\nAtuacaoService: Problemas na insercao da atuacao");
			return false;
		}
		return true;
	}

	@Override
	public Optional<Atuacao> findById(String regiao) {
		return atuacaoRepository.findById(regiao);
	}

}
