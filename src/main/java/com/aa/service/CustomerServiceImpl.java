package com.aa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.dao.CustomerDAO;
import com.aa.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	public List<Customer> listAll() {
		List<Customer> listCustomers = customerDAO.findAll();
		
		return listCustomers;
	}
}
