package com.cg.evergreenpublications.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.evergreenpublications.entity.CustomerInformation;

public interface ListAllCustomersService {

	public Page<CustomerInformation> getAllCustomers(String adminEmail,String adminPassword,int adminId,int pageNumber);
}
