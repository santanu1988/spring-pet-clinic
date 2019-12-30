package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vets")
public class Vet extends Person {
	
	@Builder
	public Vet(Long id, String firstName, String lastName, Set<Speciality> specialities) {
		super(id, firstName, lastName);
		this.specialities = specialities;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), 
			inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<Speciality> specialities = new HashSet<>();

}
