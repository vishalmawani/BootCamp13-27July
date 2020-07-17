package com.cg.bookStore.dao;

import java.util.List;

import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.exceptions.AdminServiceException;

public interface BookStoreDaoI {

	public void addAdmin(Admin admin);
	
	
	public boolean editAdmin(long adminId, Admin admin);
	
	
	
	public List<Admin> retreiveList(long adminId) throws AdminServiceException;
	public Admin getAdmin(long adminId);
	

//	
//	public List<CustomerInformation> findAll();

}
