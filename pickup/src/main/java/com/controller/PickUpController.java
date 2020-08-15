package com.controller;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.PickUpRepository;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
public class PickUpController {

	@Autowired

	 private PickUpRepository picpkuRepo;

	 @Autowired

	 private PetRepository petRepo;



	 Logger log= LoggerFactory.getLogger(PickUpController.class);



	 @RequestMapping("/getPickups")

	 public Iterable<PickUp> getAdmin()

	 {

	 log.info("Request for all pickup details");

	 return picpkuRepo.findAll();

	 }



	 @PostMapping("/buyPet/{petid}/{userid}")

	 public Pet buyPet(@RequestBody PickUp pickup,@PathVariable("petid") Long petid,@PathVariable("userid") Long userid)

	 {

	 log.info("Request for pickup pet: " + petid);

	 pickup.setPetid(petid);

	 pickup.setUserid(userid);

	 System.out.println("pickuped pet with id: "+petid);

	 picpkuRepo.save(pickup);

	 Optional<Pet> pet= petRepo.findById(petid);

	 return pet.get();

	 }

	}



