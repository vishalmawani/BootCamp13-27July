package com.cg.BookStore.DAO;

import java.util.List;

import com.cg.BookStore.Entities.Admin;

public interface AdminDAOI {
	
	public boolean checkAdminByEmail(String email);
	public void persistAdmin(Admin admin);
	public Admin FindByAdminEmail(String email);
	public List<String> retrieveAdmin();
	public Admin getAdmin( Integer admin_id);

}
