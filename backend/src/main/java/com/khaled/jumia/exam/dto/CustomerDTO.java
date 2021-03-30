package com.khaled.jumia.exam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {

	private String name;
	private String phone;
	private String country;
	private boolean valid;
}