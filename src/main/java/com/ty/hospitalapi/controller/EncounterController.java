package com.ty.hospitalapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospitalapi.dto.Encounter;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.service.EncounterService;

@RestController
public class EncounterController {

	@Autowired
	EncounterService encounterService;

	@PostMapping("/encounters")
	public ResponseStructure<Encounter> saveEncounter(@RequestParam int bid, @RequestParam int pid,
			@RequestBody Encounter encounter) {
		return encounterService.createEncounter(bid, pid, encounter);

	}

	@GetMapping("/encounters/{id}")
	public ResponseStructure<Encounter> getEncounterById(@PathVariable int id) {
		return encounterService.getEncounterById(id);

	}

	/*
	 * @GetMapping("/branchs") public ResponseStructure<List<Branch>>
	 * getAllEncounter() { return encounterService.getAllEncounters();
	 * 
	 * }
	 */

	@PutMapping("/encounters/{id}")
	public ResponseStructure<Encounter> updateEncounter(@RequestBody Encounter encounter, @PathVariable int id) {
		return encounterService.updateEncounter(encounter, id);

	}

	@DeleteMapping("/encounters/{id}")
	public ResponseStructure<String> deleteBranch(@PathVariable int id) {
		return encounterService.deleteEncounterById(id);
	}
}
