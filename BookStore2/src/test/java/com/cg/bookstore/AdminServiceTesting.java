package com.cg.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookstore.dao.AdminDaoImpl;
import com.cg.bookstore.entities.Admin;
import com.cg.bookstore.service.AdminServiceImpl;

@RunWith(SpringRunner.class)
public class AdminServiceTesting {

	@Autowired
	AdminServiceImpl adminServiceImplTest;
	
	@MockBean
	AdminDaoImpl adminDaoImplTest;
	
	@Test
	public void adminServiceTest() throws Exception{
	Admin admin = new Admin();	
	admin.setAdminId(105);
	admin.setEmail("vishal@gmail.com");
	admin.setFullName("Vishal Kumar");
	admin.setPassword("12345");
	Mockito.when(adminDaoImplTest.editAdmin(admin.getAdminId(), admin)).thenReturn(true);
	assertThat(adminServiceImplTest.editAdmin(admin.getAdminId(), admin)).isEqualTo("Admin Updated");
	}
}




