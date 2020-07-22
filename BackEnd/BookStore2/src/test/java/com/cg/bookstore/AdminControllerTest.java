package com.cg.bookstore;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookstore.controller.AdminController;
import com.cg.bookstore.service.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerTest {

	
	@Autowired
	private AdminController adminController;
	
	@MockBean
	private AdminService adminService;
	
	@Test
	public void addAdminTest() {
		
	}

}
