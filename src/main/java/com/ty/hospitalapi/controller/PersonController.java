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

import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.dto.PersonValidate;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@PostMapping("/persons")
	public ResponseStructure<Person> savePerson(@RequestBody Person user) {
		return personService.savePerson(user);

	}

	@GetMapping("/persons/{id}")
	public ResponseStructure<Person> getPersonById(@PathVariable int id) {
		return personService.getPersonById(id);

	}

	@GetMapping("/persons")
	public ResponseStructure<List<Person>> getAllPerson() {
		return personService.getAllPerson();

	}

	@PostMapping("/persons/validate")
	public ResponseStructure<Person> validatePerson(@RequestBody PersonValidate personValidate) {
		return personService.validatePerson(personValidate.getEmail(), personValidate.getPhone());

	}

	@PutMapping("/persons/{id}")
	public ResponseStructure<Person> updatePerson(@RequestBody Person user, @PathVariable int id) {
		return personService.updatePerson(user, id);

	}

	@DeleteMapping("/persons/{id}")
	public ResponseStructure<String> deletePerson(@PathVariable int id) {
		return personService.deletePerson(id);
	}
}
