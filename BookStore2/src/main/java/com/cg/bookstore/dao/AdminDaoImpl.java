package com.cg.bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.bookstore.dto.AdminDto;
import com.cg.bookstore.entities.Admin;

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
		editAdmin.setEmail(admin.getEmail());
		editAdmin.setFullName(admin.getFullName());
		editAdmin.setPassword(admin.getPassword());
		entityManager.merge(editAdmin);
		return true;
	}

	

}
