package com;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.controller.PetController;
import com.dao.PetRepository;
import com.pojo.Pet;

@SpringBootTest
@ExtendWith(value = SpringExtension.class)
class Petkart3ApplicationTests {
	@Autowired
	private PetRepository petRepo;
	@Autowired
	private PetController petController;
	boolean run=true;
	@BeforeEach
	public void setUp() {
		Pet pet = new Pet();
		pet.setPetDescription("greycolor");
		pet.setPetType("cat");
		pet.setPetId("5");
		pet.setPetPrice(122);
		pet.setPetName("pomorian");
		
		petRepo.save(pet);
	}

	@AfterEach
	public void cleanUp() {
		if(run==false)

			  return;
		
		petRepo.deleteById("1");
	}

	@Test
	void shouldSavePet() {
		// arrange
		Pet pet = new Pet();
		pet.setPetDescription("ramya12");
		pet.setPetType("ramyagajawada55@gmail.com");
		pet.setPetId("9");
		pet.setPetPrice(12);
		pet.setPetName("ramya1234");
//act
		Pet savedPet = petController.savePet(pet);
		// assert
		Assertions.assertThat(savedPet.getPetDescription()).isEqualTo(pet.getPetDescription());
		Assertions.assertThat(savedPet.getPetType()).isEqualTo(pet.getPetType());
		Assertions.assertThat(savedPet.getPetId()).isEqualTo(pet.getPetId());
		Assertions.assertThat(savedPet.getPetPrice()).isEqualTo(pet.getPetPrice());
		Assertions.assertThat(savedPet.getPetName()).isEqualTo(pet.getPetName());
		
	}

	@Test
	void shouldUpdateSavedPet() {
		// arrange
		Pet pet = new Pet();
		pet.setPetDescription("greycolor");
		pet.setPetType("dog");
		pet.setPetId("5");
		
		pet.setPetPrice(122);
		pet.setPetName("pomorian");
//act
		Pet updatedPet = petController.updatePet(pet, "5");
		// assert
		Assertions.assertThat(updatedPet.getPetType()).isEqualTo(pet.getPetType());

	}

	@Test
	void shouldDeletePet() {
		// arrange
		// act
		run=false;
		boolean deletedPet = petController.deletePet("9");
		// assert
		Assertions.assertThat(deletedPet).isTrue();
		Assertions.assertThat(petRepo.findAll()).hasSize(0);

	}
	@Test
	void shouldRetriveUser() {
		//act
		Pet foundPet=petController.findOneInAll("5");
		//assert
		Assertions.assertThat(foundPet).isNotNull();
		
	}


	

}
