package com.cg.BookStore.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.BookStore.DAO.LoginDAOI;
import com.cg.BookStore.Entities.Admin;
import com.cg.BookStore.Entities.Customer;
import com.cg.BookStore.Exception.NotRegisteredException;
import com.cg.BookStore.Exception.WrongCredentialsException;

@Transactional
@Service
public class LoginServiceImp implements LoginServiceI{
	
	@Autowired
	LoginDAOI loginDAO;
	

	@Override
	public Integer loginCustomer(String email, String password) {
		
		if(!loginDAO.checkCustomeByEmail(email))
				throw new NotRegisteredException("Customer is not registered with this email");
		
		
		Customer customer=loginDAO.FindByCustomerEmail(email);
		
		if(customer.getPassword().equals(password)==false)
				throw new WrongCredentialsException("The password does not match the Email provided");
			
		return customer.getcustomer_id();
	}
	
	

	@Override
	public Integer loginAdmin(String email, String password) {
		if(!loginDAO.checkAdminByEmail(email))
				throw new NotRegisteredException("Admin is not registered with this email");
		
		Admin admin=loginDAO.FindByAdminEmail(email);
		
		if(admin.getPassword().equals(password)==false)
				throw new NotRegisteredException("Admin is not registered with this email");
		return admin.getAdminId();
	}

}
