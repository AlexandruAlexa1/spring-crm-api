package com.aa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aa.dao.CustomerDAO;
import com.aa.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> listAll() {
		return customerDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		customerDAO.save(customer);
	}

	@Override
	@Transactional
	public Customer get(Integer id) {
		Customer customer = customerDAO.findById(id);
		
		return customer;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		customerDAO.deleteById(id);
	}
}
