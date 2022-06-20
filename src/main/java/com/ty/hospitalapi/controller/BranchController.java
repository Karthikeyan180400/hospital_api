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

import com.ty.hospitalapi.dto.Branch;
import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.service.BranchService;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@PostMapping("/branchs/{hospital_id}")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch, @PathVariable int hospital_id) {
		return branchService.saveBranch(branch, hospital_id);

	}

	@GetMapping("/branchs/{id}")
	public ResponseStructure<Branch> getBranchById(@PathVariable int id) {
		return branchService.getBranchById(id);

	}
	
	@GetMapping("/branchs/hospital/{id}")
	public ResponseStructure<Hospital> getBranchHospitalById(@PathVariable int id) {
		return branchService.getBranchHospitalById(id);

	}

	@GetMapping("/branchs")
	public ResponseStructure<List<Branch>> getAllBranch() {
		return branchService.getAllBranch();

	}

	@PutMapping("/branchs/{id}")
	public ResponseStructure<Branch> updateBranch(@RequestBody Branch branch, @PathVariable int id) {
		return branchService.updateBranch(branch, id);

	}

	@DeleteMapping("/branchs/{id}")
	public ResponseStructure<String> deleteBranch(@PathVariable int id) {
		return branchService.deleteBranchById(id);
	}
}
