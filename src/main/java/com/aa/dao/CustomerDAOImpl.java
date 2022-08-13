package com.aa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		
		List<Customer> listCustomers = session.createQuery("FROM Customer", Customer.class).getResultList();
		
		return listCustomers;
	}

	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer findById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<?> query = session.createQuery("DELETE FROM Customer WHERE id = :id");
		query.setParameter("id", id);
		
		query.executeUpdate();
	}

}