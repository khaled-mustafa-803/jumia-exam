package com.khaled.jumia.exam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.khaled.jumia.exam.dto.CustomerDTO;
import com.khaled.jumia.exam.util.Constant;

@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	CustomerService customerService;

	@Test
	public void listCusomters_NoFilters() {
		Page<CustomerDTO> customersPage = customerService.listCustomers(PageRequest.of(0, 10), null);
		assertNotNull(customersPage);
		assertNotNull(customersPage.getContent());
		assertEquals(0, customersPage.getNumber());
		assertEquals(10, customersPage.getSize());
	}
	
	@Test
	public void listCusomters_WithNameFilter() {
		Page<CustomerDTO> customersPage = customerService.listCustomers(PageRequest.of(0, 10), Map.of("name", "hou"));
		assertNotNull(customersPage);
		assertNotNull(customersPage.getContent());
		assertEquals(0, customersPage.getNumber());
		assertEquals(10, customersPage.getSize());
		assertTrue(customersPage.getNumberOfElements() > 0);
	}
	
	@Test
	public void listCusomters_WithCountryFilter() {
		Page<CustomerDTO> customersPage = customerService.listCustomers(PageRequest.of(0, 10), Map.of("country", Constant.CAMEROON_CODE));
		assertNotNull(customersPage);
		assertNotNull(customersPage.getContent());
		assertEquals(0, customersPage.getNumber());
		assertEquals(10, customersPage.getSize());
		assertTrue(customersPage.getNumberOfElements() > 0);
	}
	
	@Test
	public void listCusomters_WithInvalidCountryFilter() {
		Page<CustomerDTO> customersPage = customerService.listCustomers(PageRequest.of(0, 10), Map.of("country", "1"));
		assertNotNull(customersPage);
		assertNotNull(customersPage.getContent());
		assertEquals(0, customersPage.getNumber());
		assertEquals(10, customersPage.getSize());
		assertTrue(customersPage.getNumberOfElements() == 0);
	}

}
