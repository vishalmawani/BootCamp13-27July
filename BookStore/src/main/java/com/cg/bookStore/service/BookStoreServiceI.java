package com.cg.bookStore.service;

import java.util.List;

import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.exceptions.AdminServiceException;

public interface BookStoreServiceI {

	public String addAdmin(Admin admin) throws AdminServiceException;
	
	
	
	public String editAdmin(long adminId, Admin admin) throws AdminServiceException;
	
	
	
	public List<Admin> getUserList(long adminId) throws AdminServiceException;
	
//	
//	
//	public boolean save(CustomerInformation customerInformation);
}
