package com.example.desafio.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.model.Vendedor;
import com.example.desafio.service.VendedorService;

import view.VendedorView;

@RestController
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@PostMapping("/vendedor")
	public ResponseEntity<Vendedor> save(@Valid @RequestBody Vendedor vendedor){
		if(vendedorService.save(vendedor)) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}else{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/vendedor")
	public ResponseEntity<List<VendedorView>> getAll(){
		List<VendedorView> vendedores = vendedorService.findAll();
		if(!vendedores.isEmpty()) {
			return new ResponseEntity<List<VendedorView>>(vendedores ,HttpStatus.ACCEPTED);
		}else{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/vendedor/{id}")
	public ResponseEntity<VendedorView> findByID(@PathVariable Long id) {
		VendedorView vendedorView = vendedorService.findById(id);
		if(vendedorView!=null) {
			return new ResponseEntity<VendedorView>(vendedorView,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
