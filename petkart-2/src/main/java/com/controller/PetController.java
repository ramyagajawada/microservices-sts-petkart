package com.controller;



import java.util.Optional;

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

import com.pojos.Pet;



@RestController

@RequestMapping



public class PetController {

 @Autowired

 private PetRepository petRep;



 @RequestMapping("/getPets")

 public Iterable<Pet> getPets()

 {

 return petRep.findAll();

 }



 @PostMapping("/savePet")

 public Pet savePet(@RequestBody Pet pet)

 {

 System.out.println(pet);

 petRep.save(pet);

 return pet;

 }



 @DeleteMapping("/deletePet/{petId}")

 public Pet deletePet(@RequestBody Pet pet,@PathVariable("petId") String petId)

 {

 System.out.println(pet);

 petRep.deleteById(petId);

 return pet;

 }



 @GetMapping("/findOneInAll/{petId}")

 public Pet findOneInAll(@PathVariable("petId") String petId)

 {

 Optional<Pet> pet= petRep.findById(petId);

 return pet.get();

 }

}