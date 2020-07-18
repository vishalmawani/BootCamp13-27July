package com.cg.bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "adminId_generator")
	@SequenceGenerator(name = "adminId_generator", initialValue = 101, allocationSize = 1)
	private long adminId;

	@Column(length = 64)
	private String email;

	@Column(length = 30)
	private String fullName;

	@Column(length = 16)
	private String password;

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", email=" + email + ", fullName=" + fullName + ", password=" + password
				+ "]";
	}

	public Admin(long adminId, String email, String fullName, String password) {
		
		this.adminId = adminId;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}

	public Admin() {
		
	}
	

}
