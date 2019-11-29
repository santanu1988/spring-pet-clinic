package com.example.demo.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.model.Owner;
import com.example.demo.services.OwnerService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }
    
    public Set<Owner> findAll(){
        return super.findAll();
    }
    
    public Owner findById(Long id) {
        return super.findById(id);
    }
    
    public void deleteById(Long id) {
        super.deleteById(id);
    }
    
    public void delete(Owner object) {
        super.delete(object);
    }

	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}
	
}
