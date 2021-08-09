package com.qa.tdl.integrationTesting;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.qa.tdl.entity.Item;
import com.qa.tdl.repositories.ItemRepository;
import com.qa.tdl.service.ItemService;

@SpringBootTest
public class ItemServiceTest {
	
	@MockBean
	private ItemRepository repo;
	
	@MockBean
	private Item item;
	
	@Autowired
	private ItemService service;

	
	@Test
	void testCreate() {
		//Given
		Item task = new Item("Task-1", "Completed");
		Item taskWithId = new Item(1, "Task-1", "Completed");
		
		//When
		Mockito.when(this.repo.saveAndFlush(task)).thenReturn(taskWithId);
		
		
		//Then
		assertThat(this.service.createItem(task)).isEqualTo(taskWithId);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(task);
		
	}
	
	@Test
	void testReadAll() {
		//Given
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1, "Task-2", "Completed"));
		
		//When
		Mockito.when(this.repo.findAll()).thenReturn(expected);
		
		
		//Then
		assertEquals(this.service.getAllItems(), expected);
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
		
	}
	
	@Test
	void testUpdate() {
//		//Given
//		Item item = new Item("Task-20", "Completed");
//		Item itemWithID = new Item(1, "Task-20", "Completed");
//		Item updated = new Item("Task-30", "To-Do");
//		Item updateWithID = new Item(1, "Task-30", "To-Do");
//
//	
//		//When
//		Mockito.when(this.repo.saveAndFlush(item)).thenReturn(itemWithID);
//		Mockito.when(this.repo.saveAndFlush(updated)).thenReturn(updateWithID);
//		
//		
//		
//		//Then
//		assertEquals(this.service.updateItem(1, updated), updateWithID);
//		
//		//Verify
//		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(item);
//		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(updated);
		
		
	}
	
	@Test
	void testDelete() {
//		Item item = new Item("Task-20", "Completed");
//		Item newItem = new Item(1, "Task-20", "Completed");
//		Mockito.when(this.repo.save(item)).thenReturn(newItem);
//		service.deleteItem(newItem.getId());
//		Mockito.verify(this.repo, Mockito.times(1)).save(item);
//		Mockito.verify(this.repo, Mockito.times(1)).deleteById(item.getId());
//		

	}
}
