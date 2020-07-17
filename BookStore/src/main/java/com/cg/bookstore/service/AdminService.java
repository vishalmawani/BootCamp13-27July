package com.cg.bookstore.service;

import com.cg.bookstore.dto.AdminDto;
import com.cg.bookstore.entities.Admin;
import com.cg.bookstore.exceptions.AdminException;

public interface AdminService {

	public boolean addAdmin(AdminDto adminDto);
	public String editAdmin(long adminId, Admin admin) throws AdminException;
}