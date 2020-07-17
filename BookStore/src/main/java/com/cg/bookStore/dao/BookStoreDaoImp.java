package com.cg.bookStore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.exceptions.AdminServiceException;

@Repository
public class BookStoreDaoImp implements BookStoreDaoI{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addAdmin(Admin admin) {

		entityManager.persist(admin);
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
	
	
	
	
	@Override
	public List<Admin> retreiveList(long adminId) throws AdminServiceException {
		
		String Qstr="Select admin from Admin admin Where Not admin.adminId =: adminId";
		try {
		TypedQuery<Admin> query= entityManager.createQuery(Qstr,Admin.class).setParameter("adminId", adminId);
		return query.getResultList();
		}
		catch(Exception e)
		{
			throw new AdminServiceException("The List you want to access does not exist");
		}
	}

	@Override
	public Admin getAdmin(long adminId) {
		Admin admin=entityManager.find(Admin.class, adminId);
		return admin;
	}
	
	
	
	
//	@Override
//	public boolean save(CustomerInformation customer) {
//		if(customer.getAddress()==null || customer.getCity()==null || customer.getCountry()==null || customer.getEmailAddress()==null || customer.getFullName()==null || 
//				customer.getPassword()==null || customer.getPhoneNumber()==null || customer.getZipCode()==0  )
//		{
//			return false;
//		}
//		entityManager.persist(customer);
//		return true;
//		
//	}
}
