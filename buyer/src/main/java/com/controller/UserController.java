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

import com.dao.UserRepository;

import com.pojos.User;



@RestController

@RequestMapping("/user")



public class UserController {

 @Autowired

 private UserRepository userRep;



 @GetMapping("/getUser")

 public Iterable<User> getUser()

 {

 return userRep.findAll();

 }



 @PostMapping("/saveUser")

 public User saveUser(@RequestBody User user)

 {

 System.out.println(user);

 userRep.save(user);

 return user;

 }
 @PutMapping("/putUser/{userId}")

 public User updateUser(@RequestBody User user,@PathVariable("userId") String userId)

 {



	user.setUserId(userId);

 System.out.println(user);



 userRep.save(user);

 return user;

 }

 @DeleteMapping("/deleteUser/{userId}")

 public boolean deleteUser(@PathVariable("userId") String userId)

 {

 System.out.println(userId);

 userRep.deleteById(userId);

 return true;

 }



 @GetMapping("/findOneInAll/{userId}")

 public User findOneInAll(@PathVariable("userId") String userId)

 {

 Optional<User> user= userRep.findById(userId);

 return user.get();

 }

}