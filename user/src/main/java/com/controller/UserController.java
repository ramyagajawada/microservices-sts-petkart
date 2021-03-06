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
import com.dao.UserRepository;
import com.feign.PetFeign;
import com.pojos.User;
import com.userbo.UserBo;

@RestController

@RequestMapping("/user")


public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired

	private UserRepository userRep;

	@Autowired
	PetFeign pf;

	@GetMapping("/getUser")

	public Iterable<User> getUser()

	{
		log.info("Request for all admin details");
		return userRep.findAll();

	}

	@PostMapping("/saveUser")

	public User saveUser(@RequestBody User user)

	{

		System.out.println(user);

		User savedUser=userRep.save(user);

		return savedUser;

	}

	@PutMapping("/putUser/{userId}")

	public User updateUser(@RequestBody User user, @PathVariable("userId") String userId)

	{
		 log.info("Request for updating : " + userId);
		User foundUser = findOneUser(userId);
		if (foundUser != null) {
			foundUser.setConfirmed(user.getConfirmed());
			foundUser.setEmail(user.getEmail());
			foundUser.setPetId(user.getPetId());
			foundUser.setUserId(user.getUserId());
			foundUser.setUserName(user.getUserId());
			foundUser.setUserPwd(user.getUserPwd());
		}


		User savedUser=userRep.save(foundUser);

		return savedUser;
	}

	@DeleteMapping("/deleteUser/{userId}")

	public boolean deleteUser(@PathVariable("userId") String userId)

	{
		log.info("Request for deleting : " + userId);
		System.out.println(userId);
		Optional<User> user = userRep.findById(userId);
		if (user == null) {

			throw new RuntimeException("No value present");

		}
		userRep.deleteById(userId);

		return true;

	}

	@GetMapping("/findOneUser/{userId}")

	public User findOneUser(@PathVariable("userId") String userId)

	{
		log.info("Request recieved for: " + userId);
		Optional<User> user = userRep.findById(userId);

		return user.get();

	}

	@GetMapping("/findOneInAll3/{userId}")
	public UserBo findOneInAll3(@PathVariable("userId") String userId) {
		Optional<User> user = userRep.findById(userId);
		User ur = user.get();

		UserBo bo = new UserBo();

		bo.setUserName(ur.getUserName());
		bo.setUserPwd(ur.getUserPwd());
		bo.setUserId(ur.getUserId());
		bo.setEmail(ur.getEmail());
		bo.setConfirmed(ur.getConfirmed());
		bo.setPetId(ur.getPetId());
		bo.setPetPrice(pf.getpetPrice(ur.getPetId()));
		return bo;
	}

}