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

	@GetMapping
	public ResponseEntity<List<Item>> getAllItems() {
		List<Item> data = this.itemService.getAllItems();

		// return new ResponseEntity<List<User>>(data, HttpStatus.OK);

		if (data != null) {
			return new ResponseEntity<List<Item>>(data, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Item>>(data, HttpStatus.NOT_FOUND);
		}

	}

}
