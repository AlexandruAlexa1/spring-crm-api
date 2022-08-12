package com.aa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aa.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> findAll() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Customer> listCustomers = session.createQuery("from Customer", Customer.class).getResultList();
		
		return listCustomers;
	}

	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(customer);
	}

}