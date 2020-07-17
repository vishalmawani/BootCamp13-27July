package com.cg.BookStore.services;

public interface LoginServiceI {
	
	Integer loginCustomer(String email, String customer_password);
	
	Integer loginAdmin(String email, String admin_password);

}
