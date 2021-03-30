package com.khaled.jumia.exam.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.khaled.jumia.exam.entity.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
	Page<Customer> findAll( Specification<Customer> customerSpecification ,Pageable pageable);
	long count(Specification<Customer> customerSpecification);
}
