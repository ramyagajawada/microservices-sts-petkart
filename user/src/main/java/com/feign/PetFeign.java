package com.feign;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "petPrice", url = "http://localhost:8894/pets")

public interface PetFeign {

	@GetMapping("/petId/{petId}")

	public Integer getpetPrice(@PathVariable(value = "petId") String petId);

}