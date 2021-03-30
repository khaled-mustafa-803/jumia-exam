package com.khaled.jumia.exam.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void listCustomers_NoQueryParameters() throws Exception {
		String responseContent = mockMvc.perform(get("/customer")).andExpect(status().isOk()).andReturn().getResponse()
				.getContentAsString();
		assertTrue(responseContent.contains("\"totalElements\":41"));
	}

	@Test
	public void listCustomers_WithPagination() throws Exception {
		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();

		queryParams.add("page", "0");
		queryParams.add("size", "10");
		String responseContent = mockMvc.perform(get("/customer").queryParams(queryParams)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		assertTrue(responseContent.contains("\"numberOfElements\":10"));
	}
	
	@Test
	public void listCustomers_WithNameFilter() throws Exception {
		MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();

		queryParams.add("page", "0");
		queryParams.add("size", "10");
		queryParams.add("name", "houd");
		String responseContent = mockMvc.perform(get("/customer").queryParams(queryParams)).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		assertTrue(responseContent.contains("Houd"));
	}

}
