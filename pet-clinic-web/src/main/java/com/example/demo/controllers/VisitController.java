package com.example.demo.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Pet;
import com.example.demo.model.Visit;
import com.example.demo.services.PetService;
import com.example.demo.services.VisitService;

@Controller
public class VisitController {
	
	private final VisitService visitService;
	private final PetService petService;
	
	public VisitController(VisitService visitService, PetService petService) {
		this.visitService = visitService;
		this.petService = petService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@ModelAttribute("visit")
	public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Map<String, Object> model) {
		Pet pet = petService.findById(petId);
		model.put("pet", pet);
		Visit visit = new Visit();
		pet.getVisits().add(visit);
		visit.setPet(pet);
		return visit;
	}
	
	@GetMapping("/owners/*/pets/{petId}/visits/new")
	public String initNewVisitForm(@PathVariable("petId") Long petId, Map<String, Object> model) {
		return "pets/createOrUpdateVisitForm";
	}
	
	
	@PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
	public String processVisitForm(@Valid Visit visit, @PathVariable("ownerId") Long ownerId, BindingResult result) {
		if(result.hasErrors()) {
			return "pets/createOrUpdateVisitForm";
		} else {
			visitService.save(visit);
			return "redirect:owners/" + ownerId;
		}
	}
}
