package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.HospitalDao;
import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.dto.ResponseStructure;
//import com.ty.hospitalapp.dto.Branch;
import com.ty.hospitalapi.exception.NoIdFoundException;

@Service
public class HospitalService {

	@Autowired
	HospitalDao hospitalDao;

	public ResponseStructure<Hospital> saveHospital(Hospital hospital) {
		Hospital hospital2 = hospitalDao.saveHospital(hospital);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(hospital2);
		return responseStructure;
	}

	public ResponseStructure<Hospital> getHospitalById(int id) {
		Hospital hospital = hospitalDao.getHospitalById(id);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		if (hospital != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(hospital);
		} else {
			throw new NoIdFoundException("Hospital id " + id + " does not Exists");
		}
		return responseStructure;
	}

	/*
	 * public List<Branch> getHospitalBranchesById(int id) { return
	 * hospitalDaoImp.getHospitalBranchesById(id); }
	 */

	public ResponseStructure<List<Hospital>> getAllHospital() {
		List<Hospital> hospitals = hospitalDao.getAllHospital();
		ResponseStructure<List<Hospital>> responseStructure = new ResponseStructure<List<Hospital>>();
		if (hospitals.size() > 0) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(hospitals);
		} else {
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Not Found");
			responseStructure.setData(null);
		}

		return responseStructure;
	}

	public ResponseStructure<Hospital> updateHospital(Hospital hospital, int id) {
		Hospital hospital2 = hospitalDao.updateHospital(hospital, id);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();

		if (hospital2 != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(hospital2);
		} else {
			throw new NoIdFoundException("Hospital id " + id + " does not Exists");
		}
		return responseStructure;
	}

	public ResponseStructure<String> deleteHospitalById(int id) {
		boolean res = hospitalDao.deleteHospitalById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (res) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Deleted");
		} else {
			throw new NoIdFoundException("Hospital id " + id + " does not Exists");
		}
		return responseStructure;
	}

}
