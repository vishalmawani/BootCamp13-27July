package com.cg.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.dto.AdminDto;
import com.cg.bookstore.entities.Admin;
import com.cg.bookstore.exceptions.AdminException;
import com.cg.bookstore.service.AdminService;

/************************************************************************************
 * 			@author 		Vishal Mawani
 * 
 *         Description 		Admincontroller class which provides methods for add and
 *         					edit an admin, also try if an exceptions occurs and throws
 *         					it.
 * 
 *         Created Date 	16-JUL-2020
 ************************************************************************************/
@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	/************************************************************************************
	 * Method: editAdmin
     *Description: 			  To edit information of an admin.
	 * @param adminId         - Admin's ID
	 * @param admin           - Admin class Object
	 * @returns String        -  If admin is updated
	 * @throws AdminException - It is raised if admin id is not present.
	 * @createdBy             - Vishal Mawani
	 * @created on			  - 17-JUL-2020
	 ************************************************************************************/
	@PutMapping("/editAdmin/{adminId}")
	public String editAdmin(@PathVariable long adminId, @RequestBody Admin admin) throws AdminException {
		try{
			
			return adminService.editAdmin(adminId, admin);
			} catch(Exception exception) {
				throw new AdminException(exception.getMessage());
			}
	}
	
	/************************************************************************************
	 * Method: addAdmin
     *Description: 			To create/add a new admin.
	 * @param Admindto        - AdminDto Object
	 * @returns String      -  If admin is added
	 * @throws AdminException - It is raised if admin is not added.
	 ************************************************************************************/
	@PostMapping("/addAdmin")
	public String addAdmin(@RequestBody AdminDto adminDto) throws AdminException {
		
		try{
			return adminService.addAdmin(adminDto);
		}catch(Exception exception) {
			throw new AdminException(exception.getMessage());
		}
		
	}
	

	
	
}
