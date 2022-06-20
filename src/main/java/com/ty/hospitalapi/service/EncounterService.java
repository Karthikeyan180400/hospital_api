package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.EncounterDao;
import com.ty.hospitalapi.dto.Encounter;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.exception.NoIdFoundException;

@Service
public class EncounterService {
	@Autowired
	EncounterDao encounterDao;

	public ResponseStructure<Encounter> createEncounter(int branch_id, int person_id, Encounter encounter) {
		Encounter encounter2 = encounterDao.createEncounter(branch_id, person_id, encounter);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(encounter2);
		return responseStructure;
	}

	public ResponseStructure<Encounter> getEncounterById(int id) {
		Encounter encounter = encounterDao.getEncounterById(id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();
		if (encounter != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(encounter);
		} else {
			throw new NoIdFoundException("Encounter id " + id + " does not Exists");
		}
		return responseStructure;
	}

	public List<Encounter> getEncountersByBranchId(int branch_id) {
		return encounterDao.getEncountersByBranchId(branch_id);
	}

	public List<Encounter> getEncountersByPersonId(int person_id) {
		return encounterDao.getEncountersByPersonId(person_id);
	}

	public ResponseStructure<Encounter> updateEncounter(Encounter encounter, int id) {
		Encounter encounter2 = encounterDao.updateEncounter(encounter, id);
		ResponseStructure<Encounter> responseStructure = new ResponseStructure<Encounter>();

		if (encounter2 != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(encounter2);
		} else {
			throw new NoIdFoundException("Encounter id " + id + " does not Exists");
		}
		return responseStructure;
	}

	public ResponseStructure<String> deleteEncounterById(int id) {
		boolean res = encounterDao.deleteEncounterById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (res) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Deleted");
		} else {
			throw new NoIdFoundException("Encounter id " + id + " does not Exists");
		}
		return responseStructure;
	}

}
