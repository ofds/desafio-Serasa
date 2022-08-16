package com.example.desafio.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.ToString;

@Table(name="atuacao")
@Entity
@ToString
public class Atuacao {
	
	@Id
	@NotBlank
	private String regiao;
	
	@ElementCollection(targetClass=String.class)
	private List<String> estados;
	
	public void setRegiao(String regiao) {
		this.regiao = regiao;
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
