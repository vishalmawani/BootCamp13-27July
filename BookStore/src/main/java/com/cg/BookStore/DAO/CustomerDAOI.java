package com.cg.BookStore.DAO;

import java.util.List;

import com.cg.BookStore.Entities.Customer;

public interface CustomerDAOI {
	
	public boolean checkCustomeByEmail(String email);
	public void persistCustomer(Customer customer);
	public Customer FindByCustomerEmail(String email);
	public List<String> retrievecustomer();
	public Customer getCustomer( Integer customer_id);

}
