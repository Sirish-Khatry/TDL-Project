package com.qa.tdl.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.tdl.entity.Item;
import com.qa.tdl.repositories.ItemRepository;
@Service
public class ItemService {

	private ItemRepository itemRepository;

	@Autowired
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;

	}

	public List<Item> getAllItems() {

		List<Item> itemsinDb = itemRepository.findAll();
		return itemsinDb;

	}
	
	public Item updateItem(int id, Item item) {

		if (!itemRepository.existsById(id)) {
		throw new EntityNotFoundException(); }
		Item itemInDb = itemRepository.findById(id).get();
		System.out.println(itemInDb.getTask());
		System.out.println(item.getTask());
		itemInDb.setTask(item.getTask());
		itemInDb.setStatus(item.getStatus());	
		this.itemRepository.save(itemInDb);
		
		return itemInDb;

	}
	
	public Item createItem(Item item) {

		Item savedItem = this.itemRepository.save(item);
		return savedItem;

	}
	
	public void deleteItem(int id) {

		if (!itemRepository.existsById(id))
			throw new EntityNotFoundException();
		itemRepository.deleteById(id);
	}



}
