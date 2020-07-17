package com.cg.bookstore.dto;

import com.cg.bookstore.entities.Admin;

public class AdminDto {
	
	private Admin admin;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "AdminDto [admin=" + admin + "]";
	}

	public AdminDto(Admin admin) {
		super();
		this.admin = admin;
	}

	public AdminDto() {
		super();
	}
	
	
	

}
