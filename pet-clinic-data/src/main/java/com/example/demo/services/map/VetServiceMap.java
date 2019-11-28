package com.example.demo.services.map;

import java.util.Set;

import com.example.demo.model.Vet;
import com.example.demo.services.CrudService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements CrudService<Vet, Long> {

	@Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }
    
    public Set<Vet> findAll(){
        return super.findAll();
    }
    
    public Vet findById(Long id) {
        return super.findById(id);
    }
    
    public void deleteById(Long id) {
        super.deleteById(id);
    }
    
    public void delete(Vet object) {
        super.delete(object);
    }
    
}
