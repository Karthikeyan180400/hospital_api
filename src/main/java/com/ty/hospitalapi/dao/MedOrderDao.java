package com.ty.hospitalapi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Encounter;
import com.ty.hospitalapi.dto.Item;
import com.ty.hospitalapi.dto.MedOrder;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.repository.MedOrderRepository;
import com.ty.hospitalapi.service.EncounterService;
import com.ty.hospitalapi.service.ItemService;
import com.ty.hospitalapi.service.MedOrderService;

@Repository
public class MedOrderDao {

	@Autowired
	MedOrderRepository medOrderRepository;

	@Lazy
	@Autowired
	ItemService itemService;

	@Lazy
	@Autowired
	MedOrderService medOrderService;

	@Lazy
	@Autowired
	EncounterService encounterService;

	public MedOrder saveMedOrder(MedOrder medOrder, int encounter_id) {
		ResponseStructure<Encounter> responseStructure = encounterService.getEncounterById(encounter_id);
		medOrder.setEncounter(responseStructure.getData());
		MedOrder medOrder2 = medOrderRepository.save(medOrder);
		List<Item> items = new ArrayList<Item>();
		for (Item item : medOrder2.getItems()) {
			item.setMedOrder(medOrder2);
			items.add(item);
		}
		ResponseStructure<List<Item>> responseStructure2 = itemService.saveItem(items);
		return medOrderService.setMedOrderTotal(responseStructure2.getData(), medOrder2);
	}

	public MedOrder getMedOrderById(int id) {
		Optional<MedOrder> optional = medOrderRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return optional.get();
		}
	}

	public List<MedOrder> getMedOrdersByEncounterId(int encounter_id) {
		return null;
	}

	public List<MedOrder> getMedOrdersByPersonId(int person_id) {
		return null;
	}

	public MedOrder updateMedOrder(MedOrder medOrder, int id) {
		Optional<MedOrder> optional = medOrderRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			if (medOrder.getId() == optional.get().getId()) {
				List<Item> items = new ArrayList<Item>();
				for (Item item : medOrder.getItems()) {
					item.setMedOrder(medOrder);
					items.add(item);
				}
				return medOrderService.setMedOrderTotal(itemService.updateItems(items), medOrder);
			} else {
				return null;
			}
		}
	}

	public MedOrder updateMedOrderTotal(MedOrder medOrder) {
		return medOrderRepository.save(medOrder);

	}

	public boolean deleteMedOrderById(int id) {
		Optional<MedOrder> optional = medOrderRepository.findById(id);
		if (optional.isEmpty()) {
			return false;
		} else {
			medOrderRepository.delete(optional.get());
			return true;
		}
	}

}
