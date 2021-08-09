package com.qa.tdl.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qa.tdl.entity.Item;
import com.qa.tdl.service.ItemService;

@CrossOrigin("http://127.0.0.1:5500")
@RestController
@RequestMapping("/item")
public class ItemController {

	private ItemService itemService;

	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Item>> getAllItems() {
		List<Item> data = this.itemService.getAllItems();

		if (data != null) {
			return new ResponseEntity<List<Item>>(data, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Item>>(data, HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/create")
	public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
		Item data = this.itemService.createItem(item);

		if (data != null) {

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("localhost:80/item/" + data.getId()));
			headers.setContentType(MediaType.APPLICATION_JSON);

			return new ResponseEntity<Item>(data, headers, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Item>(data, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Item> updateItem(@Valid @PathVariable("id") int id, @RequestBody Item item) {
		Item data = this.itemService.updateItem(id, item);

		if (data != null) {
			return new ResponseEntity<Item>(data, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Item>(data, HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteItem(@PathVariable("id") int id) {
		this.itemService.deleteItem(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
