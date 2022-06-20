package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.ItemDao;
import com.ty.hospitalapi.dto.Item;
import com.ty.hospitalapi.dto.ResponseStructure;

@Service
public class ItemService {

	@Autowired
	ItemDao itemDao;

	@Autowired
	MedOrderService medOrderService;

	public ResponseStructure<List<Item>> saveItem(List<Item> items) {
		
		List<Item> items2 = itemDao.saveItem(items);
		ResponseStructure<List<Item>> responseStructure = new ResponseStructure<List<Item>>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(items2);
		return responseStructure;
	}

	public Item getItemById(int id) {
		return itemDao.getItemById(id);
	}

	/*public List<Item> getItemsByMedOrderId(int medOrder_id) {
		return itemDao.getItemsByMedOrderId(medOrder_id);
	}*/

	public List<Item> updateItems(List<Item> items) {
		return itemDao.updateItems(items);
	}

	public boolean deleteItem(int id) {
		return itemDao.deleteItem(id);
	}

}
