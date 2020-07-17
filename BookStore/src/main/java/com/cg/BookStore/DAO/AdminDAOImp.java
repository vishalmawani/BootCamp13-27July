package com.cg.BookStore.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.BookStore.Entities.Admin;
import com.cg.BookStore.Entities.Customer;

public class AdminDAOImp implements AdminDAOI{
	
	@PersistenceContext
	EntityManager entity;
	
	@Override
	public void persistAdmin(Admin admin) {
		entity.persist(admin);
		
	}

	@Override
	public boolean checkAdminByEmail(String email) {
		String checkquery="Select admin from Admin admin where admin.email= :email";
		TypedQuery<Admin> query=entity.createQuery(checkquery,Admin.class).setParameter("email",email);
		try {
			
			query.getSingleResult();
		} catch(Exception exception) {
			
			return false;
		}
		
		return true;
	}
	
	@Override
	public Admin FindByAdminEmail(String email) {
		String findquery="Select admin from Admin admin where admin.email= :email";
		TypedQuery<Admin> query=entity.createQuery(findquery,Admin.class).setParameter("email",email);
		return query.getSingleResult();
	}

	@Override
	public Admin getAdmin(Integer admin_id) {
		Admin admin=entity.find(Admin.class, admin_id);
		return admin;
	}

	

	

	@Override
	public List<String> retrieveAdmin() {
		
		Query query=entity.createQuery("from Admin admin");
		return query.getResultList();
	}

	
	

}
