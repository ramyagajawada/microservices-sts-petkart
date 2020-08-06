package com.dao;
import org.springframework.data.repository.CrudRepository;
import com.pojo.Pet;
public interface PetRepository extends CrudRepository<Pet,String>{
	Iterable<Pet> findAll();
}