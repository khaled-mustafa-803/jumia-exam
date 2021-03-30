package com.khaled.jumia.exam.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
	@Id
	private Long id;
	private String name;
	private String phone;
}
