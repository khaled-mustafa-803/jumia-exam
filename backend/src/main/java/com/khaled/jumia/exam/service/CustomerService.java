package com.khaled.jumia.exam.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.khaled.jumia.exam.dto.CustomerDTO;
import com.khaled.jumia.exam.dto.helper.CustomerHelper;
import com.khaled.jumia.exam.repository.CustomerRepository;
import com.khaled.jumia.exam.repository.specification.CustomerSpecification;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Page<CustomerDTO> listCustomers(Pageable pageable, Map<String, String> filters) {

		CustomerSpecification customerSpecification = new CustomerSpecification(filters);
		List<CustomerDTO> customerDTOs = customerRepository.findAll(customerSpecification,pageable).stream()
				.map(CustomerHelper::convertCustomerEntityToCustomerDTO).collect(Collectors.toList());
		return new PageImpl<>(customerDTOs, pageable,
				customerRepository.count(customerSpecification));
	}
}
