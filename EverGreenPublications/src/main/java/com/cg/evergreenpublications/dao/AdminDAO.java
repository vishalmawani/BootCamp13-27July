package com.cg.evergreenpublications.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.evergreenpublications.entity.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin,Integer>{

	@Query("SELECT c FROM Admin c where c.email=:adminEmail AND c.password=:adminPassword AND c.adminId=:adminId")
	public Admin getAdminByIdAndPassword(String adminEmail,String adminPassword,int adminId);
}
