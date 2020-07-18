package com.cg.BookStore.DAO;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.BookStore.Entities.Admin;
import com.cg.BookStore.Entities.Customer;
@Repository
public class LoginDAOImp implements LoginDAOI{
	
	@PersistenceContext
	EntityManager entity;

	

	@Override
	public void persistCustomer(Customer customer) {
		
		entity.persist(customer);
		
	}
	
	@Override
	public boolean checkCustomeByEmail(String emailAddress) {
		String checkquery="Select customer.emailAddress FROM Customer customer WHERE customer.emailAddress= :emailAddress";
		TypedQuery<String> query=entity.createQuery(checkquery,String.class).setParameter("emailAddress",emailAddress);
		try {
			
			query.getSingleResult();
		} catch(Exception exception) {
			
			return false;
		}
		return true;
	}
	
	@Override
	public Customer FindByCustomerEmail(String emailAddress) {
		
		String findquery="Select customer.emailAddress FROM Customer customer WHERE customer.emailAddress= :emailAddress";
		TypedQuery<Customer> query=entity.createQuery(findquery,Customer.class).setParameter("emailAddress",emailAddress);
		return query.getSingleResult();
	}
	
	@Override
	public Customer getCustomer(Integer customer_id) {
		Customer customer=entity.find(Customer.class, customer_id);
		return customer;
	}

	

	
	
	@Override
	public void persistAdmin(Admin admin) {
		entity.persist(admin);
		
	}

	@Override
	public boolean checkAdminByEmail(String email) {
		String checkquery="Select admin.email FROM Admin admin WHERE admin.email= :email";
		TypedQuery<String> query=entity.createQuery(checkquery,String.class).setParameter("email",email);
		try {
			
			query.getSingleResult();
			
		} catch(Exception exception) {
			
			return false;
		}
		
		return true;
	}
	
	@Override
	public Admin FindByAdminEmail(String email) {
		String findquery="Select admin.email FROM Admin admin WHERE admin.email= :email";
		TypedQuery<Admin> query=entity.createQuery(findquery,Admin.class).setParameter("email",email);
		return query.getSingleResult();
	}

	@Override
	public Admin getAdmin(Integer admin_id) {
		Admin admin=entity.find(Admin.class, admin_id);
		return admin;
	}

	

	

	


	

	

}
