package com.prashant.redis.repo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.prashant.redis.modal.Customer;

@Repository
public class CustomerRepoImpl implements CustomerRepository {
	
	private static final String KEY = "Customer";
	 
	private RedisTemplate<String, Object> redisTemplate;
	private HashOperations<String, Long, Customer> hashOperations;
	

	public CustomerRepoImpl(RedisTemplate<String, Object> redisTemplate) {
		
		this.redisTemplate = redisTemplate;
	}

	@Override
	public void save(Customer customer) {
		hashOperations.put(KEY, customer.getId(), customer);

	}

	@Override
	public Customer find(Long id) {
		
		return hashOperations.get(KEY, id);
	}

	@Override
	public Map<Long, Customer> findAll() {
		return hashOperations.entries(KEY);
	}

	@Override
	public void update(Customer customer) {
		hashOperations.put(KEY, customer.getId(), customer);

	}

	@Override
	public void delete(Long id) {
		hashOperations.delete(KEY, id);

	}

}
