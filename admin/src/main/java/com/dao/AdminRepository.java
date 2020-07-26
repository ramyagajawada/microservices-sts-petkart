package com.dao;


import org.springframework.data.repository.CrudRepository;

import com.pojos.Admin;
public interface AdminRepository extends CrudRepository<Admin,String> {

	Iterable<Admin> findAll();
	

}






