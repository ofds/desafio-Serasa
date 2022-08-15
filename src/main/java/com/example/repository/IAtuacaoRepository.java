package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio.model.Atuacao;

public interface IAtuacaoRepository extends JpaRepository<Atuacao, String> {

}
