package com.cg.bookStore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cg.bookStore.entities.Admin;

@Repository
public class AdminDao implements AdminDaoI{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addAdmin(Admin admin) {

		entityManager.persist(admin);
	}
	
}
