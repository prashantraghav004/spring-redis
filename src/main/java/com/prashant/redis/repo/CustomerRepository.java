package com.prashant.redis.repo;

import java.util.Map;

import com.prashant.redis.modal.Customer;

public interface CustomerRepository {
	void save(Customer customer);
	Customer find(Long id);
	Map<Long, Customer> findAll();
	void update(Customer customer);
	void delete(Long id);
}
