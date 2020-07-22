package com.cg.bookstore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.dao.AdminDao;
import com.cg.bookstore.dto.AdminDto;
import com.cg.bookstore.entities.Admin;
import com.cg.bookstore.exceptions.AdminException;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	public String addAdmin(Admin admin) throws AdminException {

		if(adminDao.addAdmin(admin))
			return "Admin Added";
		else 
			throw new AdminException("Admin not added, Empty admin data");
	}

	@Override
	public String editAdmin(long adminId, Admin admin) throws AdminException{
		if(adminDao.editAdmin(adminId, admin))
			return "Admin Updated";
		else
			throw new AdminException("Admin Not Found.");
	}

}
