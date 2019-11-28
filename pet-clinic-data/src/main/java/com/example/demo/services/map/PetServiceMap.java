package com.example.demo.services.map;

import java.util.Set;

import com.example.demo.model.Pet;
import com.example.demo.services.CrudService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

	@Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }
    
    public Set<Pet> findAll(){
        return super.findAll();
    }
    
    public Pet findById(Long id) {
        return super.findById(id);
    }
    
    public void deleteById(Long id) {
        super.deleteById(id);
    }
    
    public void delete(Pet object) {
        super.delete(object);
    }
}
