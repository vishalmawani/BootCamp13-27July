package com.cg.bookStore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="bookstore_admin")
@SequenceGenerator(name="AdminIdGenerator", initialValue=100)
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AdminIdGenerator")
	private int adminId;
	
	@Column(name="FULLNAME")
	@Size(min=8,max=30)
	private String fullName;
	
	@Column(name="EMAIL")
	@Size(min=10,max=64)
	private String email;
	
	@Column(name="PASSWORD")
	@Size(min=8,max=16)
	private String password;

	public Admin() {
		super();
	}

	

	

	public Admin(int adminId, @Size(min = 8, max = 30) String fullName, @Size(min = 10, max = 64) String email,
			@Size(min = 8, max = 16) String password) {
		super();
		this.adminId = adminId;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
	}


	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}





	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

	
	
	
}
