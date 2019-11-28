package com.example.demo.services;

import java.util.Set;

import com.example.demo.model.Vet;

public interface VetService {
	
	Vet save(Vet vet);
	
	Vet findById(Long id);
	
	Set<Vet> findAll();

}
