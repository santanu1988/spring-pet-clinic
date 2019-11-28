package com.example.demo.services;

import java.util.Set;

import com.example.demo.model.Owner;

public interface OwnerService {
	
	Owner findByLastName(String lastName);
	
	Owner findById(Long id);
	
	Set<Owner> findAll();
}
