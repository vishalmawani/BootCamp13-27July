package com.cg.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@DeleteMapping("/user/{adminId}")
	public ResponseEntity<String> deleteUser(@PathVariable int adminId, @PathVariable String email) throws UserException {
		boolean result = bookStoreService.deleteUser(adminId);
		if (result) {
			response = "{\"data\":\"User Account deleted Sucessfully\"}";
		} 
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId, @PathVariable String email) throws UserException {
		boolean result = bookStoreService.deleteCustomer(email);
		if (result) {
			response = "{\"data\":\"Customer Account deleted Sucessfully\"}";
		} 
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}

