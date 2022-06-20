package com.ty.hospitalapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Item;
import com.ty.hospitalapi.repository.ItemRepository;

@Repository
public class ItemDao {

	@Autowired
	ItemRepository itemRepository;

	public List<Item> saveItem(List<Item> items) {
		return itemRepository.saveAll(items);
	}

	public Item getItemById(int id) {
		return null;
	}

	/*
	 * public List<Item> getItemsByMedOrderId(int medOrder_id) {
	 * 
	 * return medOrder.getItems(); }
	 */

	public List<Item> updateItems(List<Item> items) {
		return itemRepository.saveAll(items);
	}

	public boolean deleteItem(int id) {
		return false;
	}

}
