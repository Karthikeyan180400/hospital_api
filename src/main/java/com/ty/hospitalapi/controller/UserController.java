package com.ty.hospitalapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospitalapi.dto.Login;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.dto.User;
import com.ty.hospitalapi.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		return userService.saveUser(user);

	}

	@GetMapping("/users/{id}")
	public ResponseStructure<User> getUserById(@PathVariable int id) {
		return userService.getUserById(id);

	}

	@GetMapping("/users")
	public ResponseStructure<List<User>> getAllUser() {
		return userService.getAllUser();

	}

	@PostMapping("/users/login")
	public ResponseStructure<User> validateUser(@RequestBody Login login) {
		return userService.validateUser(login.getEmail(), login.getPassword());

	}

	@PutMapping("/users/{id}")
	public ResponseStructure<User> updateUser(@RequestBody User user, @PathVariable int id) {
		return userService.updateUser(user, id);

	}

	@DeleteMapping("/users/{id}")
	public ResponseStructure<String> deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}
}
