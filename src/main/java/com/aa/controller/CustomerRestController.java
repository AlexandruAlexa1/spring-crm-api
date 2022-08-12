package com.aa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aa.entity.Customer;
import com.aa.exception.NotFoundException;
import com.aa.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerRestController {
	
	@Autowired
	private CustomerService service;

	@GetMapping("/customers")
	public List<Customer> listAll() {
		List<Customer> listCustomers = service.listAll();
		
		return listCustomers;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		service.save(customer);
		
		return customer;
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable(name = "id") Integer id) throws NotFoundException {
		Customer customer = service.get(id);
		
		if (customer == null) {
			throw new NotFoundException("Could not find Customer with ID: " + id);
		}
		
		return customer;
	}
}
