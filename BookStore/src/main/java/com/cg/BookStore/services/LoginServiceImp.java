package com.cg.BookStore.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.BookStore.DAO.AdminDAOI;
import com.cg.BookStore.DAO.CustomerDAOI;
import com.cg.BookStore.Entities.Admin;
import com.cg.BookStore.Entities.Customer;
import com.cg.BookStore.Exception.NotRegisteredException;

@Transactional
@Service
public class LoginServiceImp implements LoginServiceI{
	
	@Autowired
	
	CustomerDAOI customerDAO;
	AdminDAOI adminDAO;

	@Override
	public Integer loginCustomer(String email, String customer_password) {
		
		if(!customerDAO.checkCustomeByEmail(email))
				throw new NotRegisteredException("Customer is not registered with this email");
		
		Customer customer=customerDAO.FindByCustomerEmail(email);
			
			
		return customer.getcustomer_id();
	}

	@Override
	public Integer loginAdmin(String email, String admin_password) {
		if(!adminDAO.checkAdminByEmail(email))
				throw new NotRegisteredException("Admin is not registered with ths email");
		
		Admin admin=adminDAO.FindByAdminEmail(email);
		return admin.getAdminId();
	}

}
