package com.ty.bootfoodapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bootfoodapp.dto.Login;
import com.ty.bootfoodapp.dto.User;
import com.ty.bootfoodapp.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	@GetMapping("/users")
	public List<User> allUser() {
		return userService.allUser();
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@DeleteMapping("/users")
	public User deleteUser(@RequestBody User user,@PathVariable int id) {
		return userService.deleteUser(id);

	}

	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User user, @PathVariable int id) {
		return userService.updateUser(user, id);
	}

//	@GetMapping("/users/{email}")
//	public List<User> findUserByEmail(@PathVariable String email) {
//		return userService.findUserByEmail(email);
//	}
//
//	@GetMapping("/users/{phone}")
//	public List<User> findByPhone(@PathVariable long phone) {
//		return userService.findByPhone(phone);
//	}

	

	@PostMapping("/users/login")
	public User validateUser(@RequestBody Login login) {
			return userService.validateUser(login.getEmail(),login.getPassword() );
	}
	
	

}
