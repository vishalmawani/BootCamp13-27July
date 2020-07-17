package com.cg.bookStore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.exceptions.AdminServiceException;
import com.cg.bookStore.service.BookStoreServiceI;

@CrossOrigin
@RestController
public class BookStoreController {

	@Autowired
	BookStoreServiceI bookStoreServiceI;
	
	@PostMapping(value="/addAdmin",consumes= {"application/json"})
	public void addAdmin(@RequestBody Admin admin) throws AdminServiceException
	{
		bookStoreServiceI.addAdmin(admin);
	}
	

	
	@PutMapping("/editAdmin/{adminId}")
	public String editAdmin(@PathVariable long adminId, @RequestBody Admin admin) throws AdminServiceException {
		try{
			
			return bookStoreServiceI.editAdmin(adminId, admin);
			} catch(Exception exception) {
				throw new AdminServiceException(exception.getMessage());
			}
	}
	
	
	
	
	@GetMapping("/adminList/{adminId}")
	public ResponseEntity<List<Admin>> getUserList(@PathVariable("adminId") Long adminId) throws AdminServiceException
	{   
		if(adminId==0)
		{
			throw new AdminServiceException("An invalid value is passed and user can't be accessed");
		}
		
		List<Admin> userList;
		userList=bookStoreServiceI.getUserList(adminId);
		return new ResponseEntity<List<Admin>>(userList,HttpStatus.OK);
	}
	
	

//	
//	@PostMapping("/customers")
//	public String addCustomer(@RequestBody CustomerInformation customerInformation)
//	{
//		try {
//			Boolean status=b.save(customerInformation);
//			if(!status) {
//			
//			throw new AdminServiceException("Can't Perform Signup Process! Check your Entered data is correct");
//			}
//		
//		}
//		catch(DataIntegrityViolationException e) {
//			return "EmailId already exist";
//		}
//		return "Customer Profile Created Successfully";
//		
//	}
}
