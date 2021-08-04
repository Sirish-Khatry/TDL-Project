package com.qa.tdl.service;

import java.util.List;

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


}
