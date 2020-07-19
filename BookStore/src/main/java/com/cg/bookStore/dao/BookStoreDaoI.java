package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.entities.QueryResponseDTO;
import com.cg.bookStore.exceptions.BookStoreServiceException;

public interface BookStoreDaoI {

	public void addAdmin(Admin admin);
	
	
	public boolean editAdmin(int adminId, Admin admin);
	
	public List<Admin> retreiveList(int adminId) throws BookStoreServiceException;
	public Admin getAdmin(int adminId);
	

	public boolean save(CustomerInformation customer);
	
	
	public boolean checkCustomeByEmail(String email);
	public void persistCustomer(CustomerInformation customer);
	public CustomerInformation FindByCustomerEmail(String email);
	public CustomerInformation getCustomer( Integer customer_id);
	public boolean checkAdminByEmail(String email);
	public void persistAdmin(Admin admin);
	public Admin FindByAdminEmail(String email);
	public Admin getAdmin( Integer admin_id);

	
	QueryResponseDTO getAllCustomers(int pageNumber);
	
	
	public boolean deleteUser(int adminId) throws BookStoreServiceException;
	public boolean deleteCustomer(CustomerInformation customer);
	CustomerInformation getCustomerByEmail(String email) throws BookStoreServiceException;
	boolean getCustomerReviewStatus(int customerId);
	boolean getOrderInformationStatus(int customerId);
}
