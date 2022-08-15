package com.example.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.entity.Atuacao;
import com.example.desafio.service.AtuacaoService;

@RestController
public class AtuacaoController {
	
	@Autowired
	AtuacaoService atuacaoService;
	
	@PostMapping("/atuacao")
	public ResponseEntity<Atuacao> save(@RequestBody Atuacao atuacao){
		if(atuacaoService.save(atuacao)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}else{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
