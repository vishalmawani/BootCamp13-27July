package com.cg.BookStore.DAO;


import com.cg.BookStore.Entities.Admin;
import com.cg.BookStore.Entities.Customer;

public interface LoginDAOI {
	
	public boolean checkCustomeByEmail(String email);
	public void persistCustomer(Customer customer);
	public Customer FindByCustomerEmail(String email);
	
	public Customer getCustomer( Integer customer_id);
	
	public boolean checkAdminByEmail(String email);
	public void persistAdmin(Admin admin);
	public Admin FindByAdminEmail(String email);
	
	public Admin getAdmin( Integer admin_id);

}
