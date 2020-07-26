package com.controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;



import org.springframework.web.bind.annotation.RequestBody;



import com.dao.AdminRepository;

import com.pojos.Admin;



@RestController

@RequestMapping("/seller")



public class AdminController {

 @Autowired

 private AdminRepository adminRep;



 @GetMapping("/getAdmin")

 public Iterable<Admin> getAdmin()

 {

 return adminRep.findAll();

 }



 @PostMapping("/saveAdmin")

 public Admin saveAdmin(@RequestBody Admin admin)

 {

 System.out.println(admin);

 adminRep.save(admin);

 return admin;

 }



 @DeleteMapping("/deleteAdmin/{AdminId}")

 public Admin deleteAdmin(@RequestBody Admin admin,@PathVariable("AdminId") String AdminId)

 {

 System.out.println(admin);

 adminRep.deleteById(AdminId);

 return admin;

 }



 @GetMapping("/findOneInAll/{AdminId}")

 public Admin findOneInAll(@PathVariable("AdminId") String AdminId)

 {

 Optional<Admin> admin= adminRep.findById(AdminId);

 return admin.get();

 }

}