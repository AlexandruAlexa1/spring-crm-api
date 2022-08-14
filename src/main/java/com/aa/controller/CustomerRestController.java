package com.aa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aa.entity.Customer;
import com.aa.exception.NotFoundException;
import com.aa.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
	
	@Autowired
	private CustomerService service;

	@GetMapping
	public List<Customer> listAll() {
		return service.listAll();
	}
	
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		service.save(customer);
		
		return customer;
	}
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable("id") Integer id) throws NotFoundException {
		Customer customer = service.get(id);
		
		if (customer == null) {
			throw new NotFoundException("Could not find any customer with ID: " + id);
		}
		
		return customer;
	}
	
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) {
		service.save(customer);
		
		return customer;
	}
	
	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable("id") Integer id) throws NotFoundException {
		Customer customer = service.get(id);
		
		if (customer == null) {
			throw new NotFoundException("Could not find any customer with ID: " + id);
		}
		
		service.delete(id);
		
		return "The customer with ID: " + id + " has been deleted successfully!";
	}
}
