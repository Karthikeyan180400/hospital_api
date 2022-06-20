package com.ty.hospitalapi.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Branch;
import com.ty.hospitalapi.dto.Encounter;
import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.repository.EncounterRepository;
import com.ty.hospitalapi.service.BranchService;
import com.ty.hospitalapi.service.PersonService;

@Repository
public class EncounterDao {

	@Autowired
	EncounterRepository encounterRepository;

	@Autowired
	PersonService personService;

	@Autowired
	BranchService branchService;

	public Encounter createEncounter(int branch_id, int person_id, Encounter encounter) {
		ResponseStructure<Branch> responseStructure = branchService.getBranchById(branch_id);
		encounter.setBranch(responseStructure.getData());
		ResponseStructure<Person> responseStructure2 = personService.getPersonById(person_id);
		encounter.setPerson(responseStructure2.getData());
		encounter.setAdmit_date_time(LocalDateTime.now());
		return encounterRepository.save(encounter);
	}

	public Encounter getEncounterById(int id) {
		Optional<Encounter> optional = encounterRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}

	public List<Encounter> getEncountersByBranchId(int branch_id) {
		return null;
	}

	public List<Encounter> getEncountersByPersonId(int person_id) {
		return null;
	}

	public Encounter updateEncounter(Encounter encounter, int id) {
		Optional<Encounter> optional = encounterRepository.findById(id);
		if (optional.isEmpty()) {
			return null;

		} else {
			if (encounter.getId() == optional.get().getId()) {
				return encounterRepository.save(encounter);
			} else {
				return null;
			}
		}
	}

	public boolean deleteEncounterById(int id) {
		Optional<Encounter> optional = encounterRepository.findById(id);
		if (optional.isEmpty()) {
			return false;
		} else {
			encounterRepository.delete(optional.get());
			return true;
		}
	}

}
