package com.cg.BookStore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.BookStore.services.LoginServiceI;

@CrossOrigin(origins="*")// for security purpose,specify which client can access, * here means no restriction 
/*
 * @Restcontroller is combination of @Controller and @ResponseBody
 * @Controller mark class as spring web MVC controller
 * @ResponseBody return objects in form of XML and JSON
 */
@RestController 

public class LoginController {
	
	@Autowired
	LoginServiceI loginservice;
	
	//GetMapping is used for get Http request
	@GetMapping(value="/customerlogin")
	public ResponseEntity<Integer> customerlogin(String email, String password) {
		Integer customerid=loginservice.loginCustomer(email, password);
		return new ResponseEntity<Integer>(customerid, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/adminlogin")
	public ResponseEntity<Integer> adminlogin(String email, String password) {
		
		Integer adminid=loginservice.loginAdmin(email, password);
		return new ResponseEntity<Integer>(adminid, HttpStatus.OK);
	}
	
	

}
