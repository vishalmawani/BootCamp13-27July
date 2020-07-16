package com.cg.evergreenpublications.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cg.evergreenpublications.dao.AdminDAO;
import com.cg.evergreenpublications.dao.ListAllCustomersDAO;
import com.cg.evergreenpublications.entity.Admin;
import com.cg.evergreenpublications.entity.CustomerInformation;
import com.cg.evergreenpublications.exceptions.InvalidCredentialsException;
import com.cg.evergreenpublications.exceptions.NoCustomerFoundException;

@Service
public class ListAllCustomersServiceImpl implements ListAllCustomersService{

	@Autowired
	private ListAllCustomersDAO listAllCustomersDao;
	
	@Autowired
	private AdminDAO adminDAO;
	
	
	public Page<CustomerInformation> getAllCustomers(String adminEmail,String adminPassword,int adminId,int pageNumber)
	{
		if(pageNumber>=0)
		{
			if(adminId>0)
			{
					Admin admin=adminDAO.getAdminByIdAndPassword(adminEmail, adminPassword,adminId);
					if(admin==null)
					{
						throw new InvalidCredentialsException("Invalid credentials!");
					}
					else
					{
						Pageable pageable=PageRequest.of(pageNumber,5,Sort.by(Direction.DESC, "customerId"));
						
					    Page<CustomerInformation> pageList=listAllCustomersDao.getAllCustomers(pageable);
					    if(pageList.hasContent())
					    {
					    	return pageList;
					    }
					    else
					    {
					    	throw new NoCustomerFoundException("There are no registered customers!");
					    }
					}
			}
			else
			{
				throw new InvalidCredentialsException("Credentials are invalid");
			}
		}
		else
		{
			throw new NoCustomerFoundException("Invalid page numnber");
		}
	}
	
	

	
}
