package com.example.demo.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.demo.model.Speciality;
import com.example.demo.model.Vet;
import com.example.demo.services.SpecialityService;
import com.example.demo.services.VetService;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialityService specialityService;
	
	public VetServiceMap(SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	@Override
    public Vet save(Vet object) {
		if(object.getSpecialities().size() > 0) {
			object.getSpecialities().forEach(speciality -> {
				if(speciality.getId() == null) {
					Speciality savedSpeciality = specialityService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		}
        return super.save(object);
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
