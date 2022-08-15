package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.desafio.entity.Vendedor;

@Repository
public interface IVendedorRepository extends JpaRepository<Vendedor, Long> {

}
