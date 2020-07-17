package com.cg.bookStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookStore.dao.BookStoreDao;
import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.exception.UserException;

/********************************************************************************
 * @author        Vaishali Tiwari 
 * Description    This is a service class performing service deleting user
                  account,calling other functions to perform services 
 * Created On     16-July-2020
 ********************************************************************************/
@Transactional
@Service
public class BookStoreServiceImplementation implements BookStoreService{
	
	@Autowired
	BookStoreDao bookStoreDao;
	
	@Override
	public boolean deleteUser(int adminId) throws UserException
	{
		return bookStoreDao.deleteUser(adminId);
	}
	
	@Override
	public boolean deleteCustomer(String email) throws UserException
	{
		CustomerInformation customer=bookStoreDao.getCustomerByEmail(email);
		boolean customerReviewStatus = bookStoreDao.getCustomerReviewStatus(customer.getCustomerId());
		
		if(customerReviewStatus==true)
		{
			throw new UserException("Review found");
		}
		
		boolean orderInformationStatus = bookStoreDao.getOrderInformationStatus(customer.getCustomerId());
		
		if(orderInformationStatus==true)
		{
			throw new UserException("Active Order");
		}
		
		return bookStoreDao.deleteCustomer(customer);
	}

}
