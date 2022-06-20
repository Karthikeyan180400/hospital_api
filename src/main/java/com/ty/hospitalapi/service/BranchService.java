package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.BranchDao;
import com.ty.hospitalapi.dto.Branch;
import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.exception.NoIdFoundException;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;

	public ResponseStructure<Branch> saveBranch(Branch branch, int hospital_id) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(branchDao.saveBranch(branch, hospital_id));
		return responseStructure;
	}

	public ResponseStructure<Branch> getBranchById(int id) {
		Branch branch = branchDao.getBranchById(id);
		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
		if (branch != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(branch);
		} else {
			throw new NoIdFoundException("Branch id " + id + " does not Exists");
		}
		return responseStructure;
	}

	public ResponseStructure<Hospital> getBranchHospitalById(int id) {
		Hospital hospital = branchDao.getBranchHospitalById(id);
		ResponseStructure<Hospital> responseStructure = new ResponseStructure<Hospital>();
		if (hospital != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(hospital);
		} else {
			throw new NoIdFoundException("Branch id " + id + " does not have Hospital");
		}
		return responseStructure;
	}

	public ResponseStructure<List<Branch>> getAllBranch() {
		List<Branch> branchs = branchDao.getAllBranch();
		ResponseStructure<List<Branch>> responseStructure = new ResponseStructure<List<Branch>>();
		if (branchs.size() > 0) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(branchs);
		} else {

		}

		return responseStructure;
	}

	/*
	 * public List<Branch> getHospitalBranches(int hospital_id) { return
	 * branchDaoImp.getHospitalBranches(hospital_id); }
	 */

	/*
	 * public List<Encounter> getBranchEncounters(int id) { return
	 * branchDaoImp.getBranchEncounters(id); }
	 */

	public ResponseStructure<Branch> updateBranch(Branch branch, int id) {
		Branch branch2 = branchDao.updateBranch(branch, id);
		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();

		if (branch2 != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(branch);
		} else {
			throw new NoIdFoundException("Branch id " + id + " does not Exists");
		}
		return responseStructure;
	}

	public ResponseStructure<String> deleteBranchById(int id) {
		boolean res = branchDao.deleteBranchById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (res) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Deleted");
		} else {
			throw new NoIdFoundException("Branch id " + id + " does not Exists");
		}
		return responseStructure;
	}

}
