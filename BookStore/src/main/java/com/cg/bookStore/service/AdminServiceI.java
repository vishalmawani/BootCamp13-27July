package com.cg.bookStore.service;

import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.exceptions.AdminServiceException;

public interface AdminServiceI {

	public String addAdmin(Admin admin) throws AdminServiceException;
}
