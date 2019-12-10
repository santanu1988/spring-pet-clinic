package com.example.demo.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.demo.model.Visit;
import com.example.demo.services.VisitService;

@Service
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
    public Visit save(Visit visit) {
		if(visit.getPet() == null || visit.getPet().getOwner() == null || visit.getPet().getId() == null 
				|| visit.getPet().getOwner().getId() == null) {
			throw new RuntimeException("Invalid Visit");
		}
        return super.save(visit);
    }
    
    public Set<Visit> findAll(){
        return super.findAll();
    }
    
    public Visit findById(Long id) {
        return super.findById(id);
    }
    
    public void deleteById(Long id) {
        super.deleteById(id);
    }
    
    public void delete(Visit object) {
        super.delete(object);
    }
}
