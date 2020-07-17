package com.cg.bookStore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.exceptions.AdminServiceException;
import com.cg.bookStore.service.AdminServiceI;

@CrossOrigin
@RestController
public class BookStoreController {

	@Autowired
	AdminServiceI adminServiceI;
	
	@PostMapping(value="/addAdmin",consumes= {"application/json"})
	public void addAdmin(@RequestBody Admin admin) throws AdminServiceException
	{
		adminServiceI.addAdmin(admin);
	}
}
