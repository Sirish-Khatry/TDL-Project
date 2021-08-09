package com.qa.tdl.integrationTesting;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.tdl.entity.Item;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:todo-schema.sql",
		"classpath:todo-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ItemControllerTest {

	@Autowired
	private MockMvc mock;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void testCreate() throws Exception {

		Item item = new Item("Test-1", "Completed");

		String itemAsJSON = this.mapper.writeValueAsString(item);

		RequestBuilder mockRequest = post("/item/create").contentType(MediaType.APPLICATION_JSON).content(itemAsJSON);

		Item savedItem = new Item(2, "Test-1", "Completed");

		String savedItemAsJSON = this.mapper.writeValueAsString(savedItem);

		ResultMatcher matchStatus = status().isCreated();

		ResultMatcher matchBody = content().json(savedItemAsJSON);
		System.out.println(itemAsJSON);
		System.out.println(savedItemAsJSON);
		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);

	}

	@Test
	public void testGetAll() throws Exception {

		RequestBuilder mockRequest = get("/item/getAll").contentType(MediaType.APPLICATION_JSON);

		Item savedItem = new Item(1, "Test-1", "Completed");
		List<Item> items = new ArrayList<>();
		items.add(savedItem);

		String savedItemAsJSON = this.mapper.writeValueAsString(items);

		ResultMatcher matchStatus = status().isOk();
		ResultMatcher matchBody = content().json(savedItemAsJSON);

		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);

	}

	@Test
	public void testUpdate() throws Exception {

		Item item = new Item("Updated-Test", "Completed");

		String itemAsJSON = this.mapper.writeValueAsString(item);

		RequestBuilder mockRequest = put("/item/update/1").contentType(MediaType.APPLICATION_JSON).content(itemAsJSON);

		Item savedItem = new Item(1, "Updated-Test", "Completed");

		String savedItemAsJSON = this.mapper.writeValueAsString(savedItem);

		ResultMatcher matchStatus = status().isAccepted();
		ResultMatcher matchBody = content().json(savedItemAsJSON);
		this.mock.perform(mockRequest).andExpect(matchBody).andExpect(matchStatus);

	}

	@Test
	public void testDelete() throws Exception {

		RequestBuilder mockRequest = delete("/item/delete/1");

		ResultMatcher matchStatus = status().isOk();
		this.mock.perform(mockRequest).andExpect(matchStatus);

	}

}
