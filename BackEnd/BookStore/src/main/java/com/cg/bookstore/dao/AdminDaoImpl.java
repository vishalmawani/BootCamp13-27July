package com.cg.bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.bookstore.dto.AdminDto;
import com.cg.bookstore.entities.Admin;

/************************************************************************************
 *          @author          Vishal Mawani
 *          
 *          Description       AdminDao class provides functionality to persist new admin
 *          				 and edit admin.
                             
  *         Created Date     15-JUL-2020
 ************************************************************************************/

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean addAdmin(AdminDto adminDto) {
		if(adminDto == null)
			return false;
		else
			{
			entityManager.persist(adminDto.getAdmin());
			return true;
			}
	}

	@Override
	public boolean editAdmin(long adminId, Admin admin) {
		Admin editAdmin = entityManager.find(Admin.class, adminId);
		if (editAdmin == null)
			return false;
		editAdmin.setFullName(admin.getFullName());
		editAdmin.setPassword(admin.getPassword());
		entityManager.merge(editAdmin);
		return true;
	}

	

}
