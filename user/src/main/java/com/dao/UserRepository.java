package com.dao;
import org.springframework.data.repository.CrudRepository;


import com.pojos.User;
public interface UserRepository  extends CrudRepository<User,String> {

	Iterable<User> findAll();

}
