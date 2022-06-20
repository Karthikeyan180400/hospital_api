package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Branch;
import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.repository.BranchRepository;
import com.ty.hospitalapi.service.HospitalService;

@Repository
public class BranchDao {

	@Autowired
	HospitalService hospitalService;
	@Autowired
	BranchRepository branchRepository;

	public Branch saveBranch(Branch branch, int hospital_id) {
		ResponseStructure<Hospital> responseStructure = hospitalService.getHospitalById(hospital_id);
		Hospital hospital = responseStructure.getData();
		branch.setHospital(hospital);

		return branchRepository.save(branch);
	}

	public Branch getBranchById(int id) {
		Optional<Branch> optional = branchRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}

	public Hospital getBranchHospitalById(int id) {
		Optional<Branch> optional = branchRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			Branch branch = optional.get();
			return branch.getHospital();
		}
	}

	public List<Branch> getAllBranch() {
		return branchRepository.findAll();
	}

	/*
	 * public List<Encounter> getBranchEncounters(int id) { return null; }
	 */

	public Branch updateBranch(Branch branch, int id) {
		Optional<Branch> optional = branchRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {

			return branchRepository.save(branch);
		}
	}

	public boolean deleteBranchById(int id) {
		Optional<Branch> optional = branchRepository.findById(id);
		if (optional.isEmpty()) {
			return false;
		} else {
			branchRepository.delete(optional.get());
			return true;
		}
	}

}
