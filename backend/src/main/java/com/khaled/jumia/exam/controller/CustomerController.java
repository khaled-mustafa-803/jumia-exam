package com.khaled.jumia.exam.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khaled.jumia.exam.dto.CustomerDTO;
import com.khaled.jumia.exam.service.CustomerService;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	@CrossOrigin
	public Page<CustomerDTO> listCustomers(
			@PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = Integer.MAX_VALUE) Pageable pageable,
			@RequestParam Map<String, String> filters) {
		return customerService.listCustomers(pageable, filters);
	}

}
