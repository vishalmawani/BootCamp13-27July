package com.cg.BookStore.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.BookStore.Entities.Customer;
@Repository
public class CustomerDAOImp implements CustomerDAOI{
	
	@PersistenceContext
	EntityManager entity;

	

	@Override
	public void persistCustomer(Customer customer) {
		
		entity.persist(customer);
		
	}
	
	@Override
	public boolean checkCustomeByEmail(String email) {
		String checkquery="Select customer from Customer customer where customer.email= :email";
		TypedQuery<Customer> query=entity.createQuery(checkquery,Customer.class).setParameter("email",email);
		try {
			
			query.getSingleResult();
		} catch(Exception exception) {
			
			return false;
		}
		return true;
	}
	
	@Override
	public Customer FindByCustomerEmail(String email) {
		
		String findquery="Select customer from Customer customer where customer.email= :email";
		TypedQuery<Customer> query=entity.createQuery(findquery,Customer.class).setParameter("email",email);
		return query.getSingleResult();
	}
	
	@Override
	public Customer getCustomer(Integer customer_id) {
		Customer customer=entity.find(Customer.class, customer_id);
		return customer;
	}

	

	@Override
	public List<String> retrievecustomer() {
		
		Query query=entity.createQuery("from Customer customer");
		return query.getResultList();
	}

	

	

}
