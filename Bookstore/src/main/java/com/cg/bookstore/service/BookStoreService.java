package com.cg.bookstore.service;
import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.bookstore.entities.Admin;
import com.cg.bookstore.entities.CustomerInformation;
import com.cg.bookstore.entities.QueryResponseDTO;


public interface BookStoreService {
	public List<Admin> getUserList(int adminId);

	public QueryResponseDTO getAllCustomers(String adminEmail,String adminPassword,int adminId,int pageNumber);
}
