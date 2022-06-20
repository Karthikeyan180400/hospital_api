package com.ty.hospitalapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.hospitalapi.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query("SELECT p FROM Person p where p.email=?1 AND p.phone=?2")
	Person validatePerson(String email, String phone);
}
