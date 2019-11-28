package com.example.demo.services.map;

import java.util.Set;

import com.example.demo.model.Owner;
import com.example.demo.services.CrudService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

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
	
}
