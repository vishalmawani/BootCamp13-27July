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

@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@PutMapping("/editAdmin/{adminId}")
	public String editAdmin(@PathVariable long adminId, @RequestBody Admin admin) throws AdminException {
		try{
			
			return adminService.editAdmin(adminId, admin);
			} catch(Exception exception) {
				throw new AdminException(exception.getMessage());
			}
	}
	
	@PostMapping("/addAdmin")
	public boolean addAdmin(@RequestBody AdminDto adminDto) {
		adminService.addAdmin(adminDto);
		return true;
	}
}
