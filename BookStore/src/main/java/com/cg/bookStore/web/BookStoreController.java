package com.cg.bookStore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.entities.QueryResponseDTO;
import com.cg.bookStore.exceptions.BookStoreServiceException;
import com.cg.bookStore.service.BookStoreServiceI;


@RestController
public class BookStoreController {

	@Autowired
	BookStoreServiceI bookStoreServiceI;
	

	/**********************************************************************************
	* Method        addAdmin
	* Description   To add another admin 
	* returns       This method return string to tell if new admin is created or not.
	* Created By    Ashok Sharma 
	* Created on    17-July-2020
	 * @throws BookStoreServiceException
	**********************************************************************************/
	
	
	@PostMapping(value="/addAdmin",consumes= {"application/json"})
	public String addAdmin(@RequestBody Admin admin) throws BookStoreServiceException
	{
		try 
		{	
			return bookStoreServiceI.addAdmin(admin);
		}
		catch(NullPointerException bookStoreException)
		{
			throw new BookStoreServiceException("Please Enter Valid Input");
		}
	}
	

	
	@PutMapping("/editAdmin/{adminId}")
	public String editAdmin(@PathVariable int adminId, @RequestBody Admin admin) throws BookStoreServiceException {
		try{
			
			return bookStoreServiceI.editAdmin(adminId, admin);
			} catch(Exception exception) {
				throw new BookStoreServiceException(exception.getMessage());
			}
	}
	
	
	
	
	@GetMapping("/adminList/{adminId}")
	public ResponseEntity<List<Admin>> getUserList(@PathVariable("adminId") int adminId) throws BookStoreServiceException
	{   
		if(adminId==0)
		{
			throw new BookStoreServiceException("An invalid value is passed and user can't be accessed");
		}
		
		List<Admin> userList;
		userList=bookStoreServiceI.getUserList(adminId);
		return new ResponseEntity<List<Admin>>(userList,HttpStatus.OK);
	}
	
	

	
	@PostMapping("/customers")
	public String addCustomer(@RequestBody CustomerInformation customerInformation) throws BookStoreServiceException
	{
		try {
			Boolean status=bookStoreServiceI.save(customerInformation);
			if(!status) {
			
			throw new BookStoreServiceException("Can't Perform Signup Process! Check your Entered data is correct");
			}
		
		}
		catch(DataIntegrityViolationException e) {
			return "EmailId already exist";
		}
		return "Customer Profile Created Successfully";
		
	}
	
	
	
	//GetMapping is used for get Http request
		@GetMapping(value="/customerlogin")
		public ResponseEntity<Integer> customerlogin(String email, String password) throws BookStoreServiceException {
			Integer customerid=bookStoreServiceI.loginCustomer(email, password);
			return new ResponseEntity<Integer>(customerid, HttpStatus.OK);
			
		}
		
		@GetMapping(value="/adminlogin")
		public ResponseEntity<Integer> adminlogin(String email, String password) throws BookStoreServiceException {
			
			Integer adminid=bookStoreServiceI.loginAdmin(email, password);
			return new ResponseEntity<Integer>(adminid, HttpStatus.OK);
		}
		
		
	
	
	@GetMapping(path = "/getallcustomers/{adminEmail}/{adminPassword}/{adminId}/{pageNumber}")
	public ResponseEntity<Object> getAllCustomers(@PathVariable("adminEmail") String adminEmail,@PathVariable("adminPassword") String adminPassword,@PathVariable("adminId") Integer adminId,@PathVariable("pageNumber") Integer pageNumber) throws BookStoreServiceException
	{
		QueryResponseDTO queryResponse=bookStoreServiceI.getAllCustomers(adminEmail, adminPassword, adminId, pageNumber);
		
		return new ResponseEntity<>(queryResponse,HttpStatus.OK);
	}
	
	
	
	/**********************************************************************************
	* Method        deleteUser
	* Description   to call the deleteUser to perform deletion task
	* returns       boolean response as Account deleted successfully if account is
	*               deleted otherwise it will throw an exception
	* Created By    Vaishali Tiwari 
	* Created on    16-July-2020
	 * @throws BookStoreServiceException 
	**********************************************************************************/

	     String response;
		@DeleteMapping("/user/{adminId}")
		public ResponseEntity<String> deleteUser(@PathVariable int adminId) throws BookStoreServiceException {
			boolean result = bookStoreServiceI.deleteUser(adminId);
			if (result) {
				response = "{\"data\":\"User Account deleted Sucessfully\"}";
			} 
			return new ResponseEntity<String>(response, HttpStatus.OK);
		}
		
		/**********************************************************************************
		* Method        deleteCustomer
		* Description   to call the deleteCustomer to perform deletion task
		* returns       boolean response as customer account deleted successfully if account is
		*               deleted otherwise it will throw an exception
		* Created By    Vaishali Tiwari 
		* Created on    16-July-2020
		 * @throws UserException 
		**********************************************************************************/
			
			@DeleteMapping("/customer/{email}")
			public ResponseEntity<String> deleteCustomer(@PathVariable String email) throws BookStoreServiceException {
				boolean result = bookStoreServiceI.deleteCustomer(email);
				if (result) {
					response = "{\"data\":\"Customer Account deleted Sucessfully\"}";
				} 
				return new ResponseEntity<String>(response, HttpStatus.OK);
			} 
	
}
