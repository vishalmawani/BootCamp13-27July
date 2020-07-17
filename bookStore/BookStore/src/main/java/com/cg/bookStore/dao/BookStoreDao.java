package com.cg.bookStore.dao;

import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.exception.UserException;

public interface BookStoreDao {
	
	public boolean deleteUser(int adminId) throws UserException;

	public boolean deleteCustomer(CustomerInformation customer);

	CustomerInformation getCustomerByEmail(String email) throws UserException;

	boolean getCustomerReviewStatus(int customerId) throws UserException;

	boolean getOrderInformationStatus(int customerId) throws UserException;

}
