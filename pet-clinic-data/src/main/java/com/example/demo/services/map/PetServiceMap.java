package com.example.demo.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pet;
import com.example.demo.services.PetService;

@Service
@Profile({"default", "map"})
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	@Override
    public Pet save(Pet object) {
        return super.save(object);
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
