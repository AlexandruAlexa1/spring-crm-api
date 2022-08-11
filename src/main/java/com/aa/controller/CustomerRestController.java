package com.aa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aa.entity.Customer;
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
}
