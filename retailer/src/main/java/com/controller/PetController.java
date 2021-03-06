package com.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.dao.PetRepository;

import com.pojo.Pet;

@RestController

@RequestMapping("/pets")

public class PetController {
	Logger log = LoggerFactory.getLogger(PetController.class);
	@Autowired

	private PetRepository petRep;

	@GetMapping("/getPet")

	public Iterable<Pet> getPet()

	{
		log.info("Request for all admin details");
		return petRep.findAll();

	}

	@PostMapping("/savePet")

	public Pet savePet(@RequestBody Pet pet)

	{

		System.out.println(pet);

		petRep.save(pet);

		return pet;

	}

	@PutMapping("/putPet/{petId}")

	public Pet updatePet(@RequestBody Pet pet, @PathVariable("petId") String petId)

	{
		log.info("Request for updating : " + petId);
		pet.setPetId(petId);

		System.out.println(pet);

		petRep.save(pet);

		return pet;

	}

	@DeleteMapping("/deletePet/{petId}")

	public boolean deletePet(@PathVariable("petId") String petId)

	{
		log.info("Request for deleting : " + petId);
		System.out.println(petId);
		Optional<Pet> pet = petRep.findById(petId);

		if (pet == null) {

			throw new RuntimeException("No value present");

		}
		petRep.deleteById(petId);

		return true;

	}

	@GetMapping("/findOneInAll/{petId}")

	public Pet findOneInAll(@PathVariable("petId") String petId)

	{
		log.info("Request recieved for: " + petId);

		Optional<Pet> pet = petRep.findById(petId);

		return pet.get();

	}

	public Integer getPetPrice1(String petId) {

		Optional<Pet> pet = petRep.findById(petId);

		Pet pt = pet.get();

		return pt.getPetPrice();

	}

	@GetMapping("/petId/{petId}") 

	public Integer getpetPrice(@PathVariable(value = "petId") String petId) {
		
		System.out.println("Iam in college application");

		return getPetPrice1(petId);

	}

}