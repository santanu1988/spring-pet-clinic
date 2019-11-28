package com.example.demo.services;

import java.util.Set;

import com.example.demo.model.Pet;

public interface PetServices {
	
	Pet findById(Long id);
	
	Pet save(Pet owner);
	
	Set<Pet> findAll();

}
