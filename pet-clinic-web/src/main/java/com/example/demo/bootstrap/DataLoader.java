package com.example.demo.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.model.PetType;
import com.example.demo.model.Vet;
import com.example.demo.services.OwnerService;
import com.example.demo.services.PetTypeService;
import com.example.demo.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Jackson");
		owner1.setAddress("123 Some street");
		owner1.setCity("Miami");
		owner1.setTelephone("1234567890");
		
		Pet michaelsDog = new Pet();
		michaelsDog.setPetType(savedDogPetType);
		michaelsDog.setOwner(owner1);
		michaelsDog.setBirthDate(LocalDate.now());
		michaelsDog.setName("Bosco");
		owner1.getPets().add(michaelsDog);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glename");
		owner2.setAddress("123 Some street");
		owner2.setCity("Miami");
		owner2.setTelephone("1234567890");
		
		Pet fionasCat = new Pet();
		fionasCat.setPetType(savedCatPetType);
		fionasCat.setOwner(owner2);
		fionasCat.setBirthDate(LocalDate.now());
		fionasCat.setName("Rosco");
		owner2.getPets().add(fionasCat);
		
		ownerService.save(owner2);
		
		System.out.println("Owners added....");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("xyz");
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessi");
		vet2.setLastName("Porter");
		
		vetService.save(vet2);
		
		System.out.println("Vets added....");
		
	}

}
