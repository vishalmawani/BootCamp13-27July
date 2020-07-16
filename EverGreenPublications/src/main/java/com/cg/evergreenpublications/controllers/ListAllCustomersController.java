package com.cg.evergreenpublications.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.evergreenpublications.entity.CustomerInformation;
import com.cg.evergreenpublications.entity.QueryResponseDTO;
import com.cg.evergreenpublications.service.ListAllCustomersServiceImpl;

@RestController
@CrossOrigin
public class ListAllCustomersController {

	@Autowired
	private ListAllCustomersServiceImpl listAllCustomersService;
	
	/*
	 * getAllCustomers is for retrieving all customers.data is retrieved only by admin
	 * so that valid admin credentials should be provided to fetch also you cannot fetch all data
	 * at once you need to specify page number to retrieve.
	 * @param adminEmail is emailaddress of admin
	 * @Param adminPassword is password of admin account
	 * @Param adminId is unique of admin 
	 * @Param pageNumber is the page which you want to fetch at a time you can fetch five records
	 * 
	 */
	//todo ask peers about password encryption 
	@GetMapping(path = "/getallcustomers/{adminEmail}/{adminPassword}/{adminId}/{pageNumber}")
	public ResponseEntity<Object> getAllCustomers(@PathVariable("adminEmail") String adminEmail,@PathVariable("adminPassword") String adminPassword,@PathVariable("adminId") Integer adminId,@PathVariable("pageNumber") Integer pageNumber)
	{
		Page<CustomerInformation> resultPages=listAllCustomersService.getAllCustomers(adminEmail,adminPassword,adminId, pageNumber);
		
		QueryResponseDTO queryResponse=new QueryResponseDTO();
		queryResponse.setList(resultPages.toList());
		queryResponse.setCurrentPageNumber(pageNumber);
		queryResponse.setTotalNoOfPages(resultPages.getTotalPages());
		
		return new ResponseEntity<>(queryResponse,HttpStatus.OK);
	}
	
	
}
