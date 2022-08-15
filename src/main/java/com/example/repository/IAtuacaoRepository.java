package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desafio.model.Atuacao;

@Repository
public interface IAtuacaoRepository extends JpaRepository<Atuacao, String> {

}
