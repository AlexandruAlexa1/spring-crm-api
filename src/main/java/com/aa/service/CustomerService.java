package com.aa.service;

import java.util.List;

import com.aa.entity.Customer;

public interface CustomerService {
	
	public List<Customer> listAll();
	
	public void save(Customer customer);
	
	public Customer get(Integer id);
}
