package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.dto.User;
import com.ty.hospitalapi.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	PersonRepository personRepository;

	public Person savePerson(Person person) {
		return personRepository.save(person);

	}

	public Person getPersonById(int id) {
		Optional<Person> optional = personRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}

	}

	public List<Person> getAllPerson() {
		return personRepository.findAll();

	}

	public Person updatePerson(Person person, int id) {
		Optional<Person> optional = personRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return personRepository.save(person);
		}

	}

	public Person validatePerson(String email, String password) {
		return personRepository.validatePerson(email, password);

	}

	public boolean deletePerson(int id) {
		Optional<Person> optional = personRepository.findById(id);
		if (optional.isEmpty()) {
			return false;
		} else {
			personRepository.delete(optional.get());
			return true;
		}

	}

}
