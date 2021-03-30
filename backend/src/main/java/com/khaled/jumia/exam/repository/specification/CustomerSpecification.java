package com.khaled.jumia.exam.repository.specification;


import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.khaled.jumia.exam.entity.Customer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerSpecification implements Specification<Customer> {

	
	private static final long serialVersionUID = 2757460377068789347L;
	
	private Map<String, String> customQuery;

	@Override
	public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		Predicate predicate = criteriaBuilder.conjunction();

		if (customQuery == null) {
			return predicate;
		}

		if (customQuery.containsKey("name")) {
			predicate.getExpressions().add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
					"%" + customQuery.get("name").toLowerCase() + "%"));

		}

		if (customQuery.containsKey("country")) {
			predicate.getExpressions().add(criteriaBuilder.like(criteriaBuilder.lower(root.get("phone")),
					"(" + customQuery.get("country").toLowerCase() + ") %"));
		}
		return predicate;

	}
}