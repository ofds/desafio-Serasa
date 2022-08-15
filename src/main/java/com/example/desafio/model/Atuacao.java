package com.example.desafio.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Table(name="atuacao")
@Entity
@ToString
public class Atuacao {
	
	@Id
	private String regiao;
	@ElementCollection(targetClass=String.class)
	private List<String> estados;
	
	public Atuacao(String regiao, List<String> estados) {
		this.regiao = regiao;
		this.estados = estados;
	}
	public List<String> getEstados() {
		return estados;
	}
	public void setEstados(List<String> estados) {
		this.estados = estados;
	}
	public String getRegiao() {
		return regiao;
	}
	
	
}
