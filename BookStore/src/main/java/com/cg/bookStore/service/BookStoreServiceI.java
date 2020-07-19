package com.cg.bookStore.service;

import java.util.List;

import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.entities.QueryResponseDTO;
import com.cg.bookStore.exceptions.BookStoreServiceException;

public interface BookStoreServiceI {

	public String addAdmin(Admin admin) throws BookStoreServiceException;
	
	
	
	public String editAdmin(int adminId, Admin admin) throws BookStoreServiceException;
	
	
	
	public List<Admin> getUserList(int adminId) throws BookStoreServiceException;
	
	
	
	public boolean save(CustomerInformation customerInformation);
	
	
	 Integer loginCustomer(String email, String password) throws BookStoreServiceException;
	
     Integer loginAdmin(String email, String password) throws BookStoreServiceException;
	
	
	QueryResponseDTO getAllCustomers(String adminEmail, String adminPassword, int adminId, int pageNumber) throws BookStoreServiceException;
	
	
	boolean deleteUser(int adminId) throws BookStoreServiceException;
	public boolean deleteCustomer(String email) throws BookStoreServiceException;
	
	
}
