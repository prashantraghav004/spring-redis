package com.prashant.redis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prashant.redis.modal.Customer;
import com.prashant.redis.repo.CustomerRepository;

public class WebController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping("/save")
	public String save() {
		System.out.println("inside save method");
		// save a single Customer
		customerRepository.save(new Customer(1, "prashant", "Raghav"));
		customerRepository.save(new Customer(2, "Nilesh", "Awasthey"));
		customerRepository.save(new Customer(3, "Nilendra", "Jain"));
		customerRepository.save(new Customer(4, "Nitin", "Parsai"));
		customerRepository.save(new Customer(5, "Sheron", "Shetty"));
 
		return "Done";
	}
	
	@RequestMapping("/findall")
	public String findAll() {
		String result = "";
		Map<Long, Customer> customers = customerRepository.findAll();
 
		for (Customer customer : customers.values()) {
			result += customer.toString() + "<br>";
		}
 
		return result;
	}
	
	@RequestMapping("/find")
	public String findById(@RequestParam("id") Long id) {
		String result = "";
		result = customerRepository.find(id).toString();
		return result;
	}
	
}
