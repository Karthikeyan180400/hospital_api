package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.PersonDao;
import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.exception.NoIdFoundException;
import com.ty.hospitalapi.exception.NotValidException;

@Service
public class PersonService {

	@Autowired
	PersonDao personDao;

	public ResponseStructure<Person> savePerson(Person person) {
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(personDao.savePerson(person));
		return responseStructure;

	}

	public ResponseStructure<Person> getPersonById(int id) {
		Person person = personDao.getPersonById(id);
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();
		if (person != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(person);
		} else {
			throw new NoIdFoundException("Person id " + id + " does not Exists");
		}
		return responseStructure;

	}

	public ResponseStructure<List<Person>> getAllPerson() {
		ResponseStructure<List<Person>> responseStructure = new ResponseStructure<List<Person>>();
		List<Person> persons = personDao.getAllPerson();
		if (persons.size() > 0) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(persons);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Not Found");
			responseStructure.setData(null);
		}

		return responseStructure;

	}

	public ResponseStructure<Person> updatePerson(Person person, int id) {
		Person person1 = personDao.updatePerson(person, id);
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();

		if (person1 != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(person1);
		} else {
			throw new NoIdFoundException("Person id " + id + " does not Exists");
		}
		return responseStructure;

	}

	public ResponseStructure<Person> validatePerson(String email, String phone) {
		Person person = personDao.validatePerson(email, phone);
		ResponseStructure<Person> responseStructure = new ResponseStructure<Person>();

		if (person != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(person);
		} else {
			throw new NotValidException("Person Not Valid");
		}
		return responseStructure;

	}

	public ResponseStructure<String> deletePerson(int id) {
		boolean res = personDao.deletePerson(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (res) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Deleted");
		} else {
			throw new NoIdFoundException("Person id " + id + " does not Exists");
		}
		return responseStructure;

	}

}
