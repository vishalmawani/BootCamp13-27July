package com.cg.BookStore.services;

public interface LoginServiceI {
	
	Integer loginCustomer(String email, String password);
	
	Integer loginAdmin(String email, String password);

}
