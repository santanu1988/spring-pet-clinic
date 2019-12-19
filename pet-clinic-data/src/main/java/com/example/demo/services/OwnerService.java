package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Owner;

public interface OwnerService  extends CrudService<Owner, Long> {
	
	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
	
}
