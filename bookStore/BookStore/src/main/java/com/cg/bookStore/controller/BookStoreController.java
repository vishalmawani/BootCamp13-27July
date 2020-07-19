package com.cg.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookStore.exception.UserException;
import com.cg.bookStore.service.BookStoreService;


/********************************************************************************
 * @author      Vaishali Tiwari 
 * Description  This is the controller class, it is responsible to manage the
 *              flow of the application.
 * Created On   16-July-2020 
 ********************************************************************************/

@RestController
public class BookStoreController {
	
	@Autowired
	BookStoreService bookStoreService;
	
	String response;
	
/**********************************************************************************
* Method        deleteUser
* Description   to call the deleteUser to perform deletion task
* returns       boolean response as Account deleted successfully if account is
*               deleted otherwise it will throw an exception
* Created By    Vaishali Tiwari 
* Created on    16-July-2020
 * @throws UserException 
**********************************************************************************/

	@DeleteMapping("/admin/deleteUser/{adminId}")
	public ResponseEntity<String> deleteUser(@PathVariable int adminId) throws UserException {
		bookStoreService.deleteUser(adminId); 
		return new ResponseEntity<String>("User Account deleted", HttpStatus.OK);
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
	
	@DeleteMapping("/admin/deleteCustomer/{email}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String email) throws UserException {
		bookStoreService.deleteCustomer(email);
		return new ResponseEntity<String>("Customer Account deleted", HttpStatus.OK);
	} 

}

