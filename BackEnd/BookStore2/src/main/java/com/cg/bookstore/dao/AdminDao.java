package com.cg.bookstore.dao;

import com.cg.bookstore.dto.AdminDto;
import com.cg.bookstore.entities.Admin;

public interface AdminDao {

	public boolean addAdmin(Admin admin);
	public boolean editAdmin(long adminId, Admin admin);
}