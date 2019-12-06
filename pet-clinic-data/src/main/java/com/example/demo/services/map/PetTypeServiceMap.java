package com.example.demo.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.model.PetType;
import com.example.demo.services.PetTypeService;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

	@Override
    public PetType save(PetType object) {
        return super.save(object);
    }
    
    public Set<PetType> findAll(){
        return super.findAll();
    }
    
    public PetType findById(Long id) {
        return super.findById(id);
    }
    
    public void deleteById(Long id) {
        super.deleteById(id);
    }
    
    public void delete(PetType object) {
        super.delete(object);
    }
}
