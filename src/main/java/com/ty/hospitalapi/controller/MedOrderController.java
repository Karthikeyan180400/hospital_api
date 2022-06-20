package com.ty.hospitalapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospitalapi.dto.MedOrder;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.service.MedOrderService;

@RestController
public class MedOrderController {

	@Autowired
	MedOrderService medOrderService;

	@PostMapping("/medorders/{encounterId}")
	public ResponseStructure<MedOrder> saveEncounter(@RequestBody MedOrder medOrder, @PathVariable int encounterId) {
		return medOrderService.saveMedOrder(medOrder, encounterId);

	}

	@GetMapping("/medorders/{id}")
	public ResponseStructure<MedOrder> getEncounterById(@PathVariable int id) {
		return medOrderService.getMedOrderById(id);

	}

	@PutMapping("/medorders/{id}")
	public ResponseStructure<MedOrder> updateEncounter(@RequestBody MedOrder medOrder, @PathVariable int id) {
		return medOrderService.updateMedOrder(medOrder, id);

	}

	@DeleteMapping("/medorders/{id}")
	public ResponseStructure<String> deleteBranch(@PathVariable int id) {
		return medOrderService.deleteMedOrderById(id);
	}
}
