package com.example.demo.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Owner;
import com.example.demo.model.Pet;
import com.example.demo.model.PetType;
import com.example.demo.model.Speciality;
import com.example.demo.model.Vet;
import com.example.demo.model.Visit;
import com.example.demo.services.OwnerService;
import com.example.demo.services.PetTypeService;
import com.example.demo.services.SpecialityService;
import com.example.demo.services.VetService;
import com.example.demo.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
		this.visitService = visitService;
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		int count = petTypeService.findAll().size();
		if(count == 0) {
			loadData();
		}
	}
	
	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		dog.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);
		
		Speciality surgery = new Speciality();
		radiology.setDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);
		
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
		
		Owner owner3 = new Owner();
		owner1.setFirstName("Santanu");
		owner1.setLastName("Jackson");
		owner1.setAddress("123 Some Bangalore Street");
		owner1.setCity("Banagalore");
		owner1.setTelephone("5745734759");
		
		Pet SantanusDog = new Pet();
		SantanusDog.setPetType(savedDogPetType);
		SantanusDog.setOwner(owner3);
		SantanusDog.setBirthDate(LocalDate.now());
		SantanusDog.setName("Bosco");
		owner3.getPets().add(SantanusDog);
		
		ownerService.save(owner1);
		
		Visit catVisit =  new Visit();
		catVisit.setPet(fionasCat);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy kitty");
		
		System.out.println("Owners added....");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("xyz");
		vet1.getSpecialities().add(savedRadiology);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Jessi");
		vet2.setLastName("Porter");
		vet2.getSpecialities().add(savedSurgery);
		
		vetService.save(vet2);
		
		System.out.println("Vets added....");
	}

}
