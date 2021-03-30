package com.khaled.jumia.exam.dto.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.khaled.jumia.exam.dto.CustomerDTO;
import com.khaled.jumia.exam.entity.Customer;

@SpringBootTest
public class CustomerHelperTest {

	private static final String ETHIOPIA = "Ethiopia";
	private static final String UGANDA = "Uganda";
	private static final String MOZAMBIQUE = "Mozambique";
	private static final String CAMEROON = "Cameroon";
	private static final String MOROCCO = "Morocco";
	private Customer customer;

	@BeforeEach
	public void setup() {
		customer = new Customer();
		customer.setId(1l);
		customer.setName("name");
	}

	@Test
	public void mapCustomerToCustomerDTO_ValidCameroonPhone() {
		customer.setPhone("(237) 697151594");
		CustomerDTO customerDto = CustomerHelper.convertCustomerEntityToCustomerDTO(customer);
		assertEquals(CAMEROON, customerDto.getCountry());
		assertTrue(customerDto.isValid());
	}

	@Test
	public void mapCustomerToCustomerDTO_ValidMozambiquePhone() {
		customer.setPhone("(258) 847651504");
		CustomerDTO customerDto = CustomerHelper.convertCustomerEntityToCustomerDTO(customer);
		assertEquals(MOZAMBIQUE, customerDto.getCountry());
		assertTrue(customerDto.isValid());
	}

	@Test
	public void mapCustomerToCustomerDTO_ValidUgandaPhone() {
		customer.setPhone("(256) 775069443");
		CustomerDTO customerDto = CustomerHelper.convertCustomerEntityToCustomerDTO(customer);
		assertEquals(UGANDA, customerDto.getCountry());
		assertTrue(customerDto.isValid());
	}

	@Test
	public void mapCustomerToCustomerDTO_ValidEthiopiaPhone() {
		customer.setPhone("(251) 914701723");
		CustomerDTO customerDto = CustomerHelper.convertCustomerEntityToCustomerDTO(customer);
		assertEquals(ETHIOPIA, customerDto.getCountry());
		assertTrue(customerDto.isValid());
	}

	@Test
	public void mapCustomerToCustomerDTO_ValidMoroccoPhone() {
		customer.setPhone("(212) 698054317");
		CustomerDTO customerDto = CustomerHelper.convertCustomerEntityToCustomerDTO(customer);
		assertEquals(MOROCCO, customerDto.getCountry());
		assertTrue(customerDto.isValid());
	}

	@Test
	public void mapCustomerToCustomerDTO_InvalidCameroonPhone() {
		customer.setPhone("(237) 917151594");
		CustomerDTO customerDto = CustomerHelper.convertCustomerEntityToCustomerDTO(customer);
		assertEquals(CAMEROON, customerDto.getCountry());
		assertFalse(customerDto.isValid());
	}

	@Test
	public void mapCustomerToCustomerDTO_InvalidMozambiquePhone() {
		customer.setPhone("(258) 747651504");
		CustomerDTO customerDto = CustomerHelper.convertCustomerEntityToCustomerDTO(customer);
		assertEquals(MOZAMBIQUE, customerDto.getCountry());
		assertFalse(customerDto.isValid());
	}

	@Test
	public void mapCustomerToCustomerDTO_InvalidUgandaPhone() {
		customer.setPhone("(256) 1175069443");
		CustomerDTO customerDto = CustomerHelper.convertCustomerEntityToCustomerDTO(customer);
		assertEquals(UGANDA, customerDto.getCountry());
		assertFalse(customerDto.isValid());
	}

	@Test
	public void mapCustomerToCustomerDTO_InvalidEthiopiaPhone() {
		customer.setPhone("(251) 6014701723");
		CustomerDTO customerDto = CustomerHelper.convertCustomerEntityToCustomerDTO(customer);
		assertEquals(ETHIOPIA, customerDto.getCountry());
		assertFalse(customerDto.isValid());
	}

	@Test
	public void mapCustomerToCustomerDTO_InvalidMoroccoPhone() {
		customer.setPhone("(212) 448054317");
		CustomerDTO customerDto = CustomerHelper.convertCustomerEntityToCustomerDTO(customer);
		assertEquals(MOROCCO, customerDto.getCountry());
		assertFalse(customerDto.isValid());
	}

	@Test
	public void mapCustomerToCustomerDTO_InvalidPhone() {
		customer.setPhone("(272) 6007989253");
		assertEquals("", CustomerHelper.convertCustomerEntityToCustomerDTO(customer).getCountry());
	}

}
