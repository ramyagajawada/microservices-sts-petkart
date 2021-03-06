package com;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.controller.UserController;
import com.dao.UserRepository;
import com.pojos.User;

@SpringBootTest
@ExtendWith(value = SpringExtension.class)
class PetkartApplicationTests {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private UserController userController;
	boolean run=true;
	@BeforeEach
	public void setUp() {
		User user = new User();
		user.setUserPwd("ramya");
		user.setEmail("ramyagajawada@gmail.com");
		user.setPetId("5");
		user.setUserId("12");
		user.setUserName("ramya");
		user.setConfirmed("confirmed");
		userRepo.save(user);
	}

	@AfterEach
	public void cleanUp() {
		if(run==false)

			  return;
		
		
		userRepo.deleteById("12");
	}

	@Test
	void shouldSaveUser() {
		// arrange
		User user = new User();
		user.setUserPwd("ramya123");
		user.setEmail("ramya@gmail.com");
		user.setPetId("6");
		user.setUserId("123");
		user.setUserName("sushmitha");
		user.setConfirmed("confirmed1");

//act
		User savedUser = userController.saveUser(user);
		// assert
		Assertions.assertThat(savedUser.getConfirmed()).isEqualTo(user.getConfirmed());
		Assertions.assertThat(savedUser.getEmail()).isEqualTo(user.getEmail());
		Assertions.assertThat(savedUser.getPetId()).isEqualTo(user.getPetId());
		Assertions.assertThat(savedUser.getUserId()).isEqualTo(user.getUserId());
		Assertions.assertThat(savedUser.getUserName()).isEqualTo(user.getUserName());
		Assertions.assertThat(savedUser.getUserPwd()).isEqualTo(user.getUserPwd());
	}

	@Test
	void shouldUpdateSavedUser() {
		// arrange
		User user = new User();
		user.setEmail("newEmail@gmail.com");
		user.setUserPwd("ramya");
		user.setPetId("5");
		user.setUserId("12");
		user.setUserName("ramya");
		user.setConfirmed("confirmed");
//act
		User updatedUser = userController.updateUser(user, "12");
		// assert
		Assertions.assertThat(updatedUser.getEmail()).isEqualTo(user.getEmail());

	}

	@Test
	void shouldDeleteUser() {
		// arrange
		// act
		run=false;
		boolean deletedUser = userController.deleteUser("12");
		// assert
		Assertions.assertThat(deletedUser).isTrue();
		Assertions.assertThat(userRepo.findAll()).hasSize(0);

	}
	@Test
	void shouldRetriveUser() {
		//act
		User foundUser=userController.findOneUser("12");
		//assert
		Assertions.assertThat(foundUser).isNotNull();
		
	}

}
