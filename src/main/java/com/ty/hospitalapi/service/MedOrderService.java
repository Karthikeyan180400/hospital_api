package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.MedOrderDao;
import com.ty.hospitalapi.dto.Item;
import com.ty.hospitalapi.dto.MedOrder;
import com.ty.hospitalapi.dto.ResponseStructure;
import com.ty.hospitalapi.exception.NoIdFoundException;

@Service
public class MedOrderService {

	@Autowired
	MedOrderDao medOrderDao;

	public ResponseStructure<MedOrder> saveMedOrder(MedOrder medOrder, int encounter_id) {
		MedOrder medOrder2 = medOrderDao.saveMedOrder(medOrder, encounter_id);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(medOrder2);
		return responseStructure;
	}

	public ResponseStructure<MedOrder> getMedOrderById(int id) {
		MedOrder medOrder = medOrderDao.getMedOrderById(id);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
		if (medOrder != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(medOrder);
		} else {
			throw new NoIdFoundException("MedOrder id " + id + " does not Exists");
		}
		return responseStructure;
	}

	public List<MedOrder> getMedOrdersByEncounterId(int encounter_id) {
		return medOrderDao.getMedOrdersByEncounterId(encounter_id);
	}

	public List<MedOrder> getMedOrdersByPersonId(int person_id) {
		return medOrderDao.getMedOrdersByPersonId(person_id);
	}

	public ResponseStructure<MedOrder> updateMedOrder(MedOrder medOrder, int id) {
		MedOrder medOrder2 = medOrderDao.updateMedOrder(medOrder, id);
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
		if (medOrder2 != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(medOrder2);
		} else {
			throw new NoIdFoundException("MedOrder id " + id + " does not Exists");
		}
		return responseStructure;

	}

	public ResponseStructure<String> deleteMedOrderById(int id) {
		boolean res = medOrderDao.deleteMedOrderById(id);
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		if (res) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Deleted");
		} else {
			throw new NoIdFoundException("MedOrder id " + id + " does not Exists");
		}
		return responseStructure;
	}

	public MedOrder setMedOrderTotal(List<Item> items, MedOrder medOrder) {
		double total_cost = 0;
		for (Item item : items) {
			total_cost = total_cost + (item.getQuantity() * item.getCost());
		}
		medOrder.setTotal(total_cost);
		return medOrderDao.updateMedOrderTotal(medOrder);

	}

}
