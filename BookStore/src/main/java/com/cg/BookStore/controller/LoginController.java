package com.cg.BookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.BookStore.Entities.*;
import com.cg.BookStore.services.LoginServiceI;

@CrossOrigin(origins="*")
@RestController
public class LoginController {
	
	@Autowired
	LoginServiceI loginservice;
	
	
	@GetMapping("/CustomerLogin")
	public ResponseEntity<Integer> customerlogin(String email, String password) {
		Integer customerid=loginservice.loginCustomer(email, password);
		return new ResponseEntity<Integer>(customerid,HttpStatus.OK);
		
	}
	
	@GetMapping("/AdminLogin")
	public ResponseEntity<Integer> adminlogin(String email, String password) {
		
		Integer adminid=loginservice.loginAdmin(email, password);
		return new ResponseEntity<Integer>(adminid,HttpStatus.OK);
	}
	
	

}
