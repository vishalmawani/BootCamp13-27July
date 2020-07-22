package com.cg.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookstore.dao.AdminDao;
import com.cg.bookstore.entities.Admin;
import com.cg.bookstore.exceptions.AdminException;
import com.cg.bookstore.service.AdminService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreApplicationTests {

	@Autowired
	private AdminService adminService;
	
	@MockBean
	private AdminDao adminDao;
	
	@Test
	public void addAdminTest() throws AdminException {
		Admin admin = new Admin(101,"vkm@gmail.com","Vishal Mawani","abcd2ne3j2");
		when(adminDao.addAdmin(admin)).thenReturn(true);
		assertEquals("Admin Added", adminService.addAdmin(admin));
	}
	
	@Test(expected = AdminException.class)
	public void addAdminTests() {
		Admin admin = null;
		when(adminDao.addAdmin(admin)).thenReturn(false);
		try{
			adminService.addAdmin(admin);
		}catch (Exception e) {
			assertEquals("Admin not added, Empty admin data", e.getMessage());
		}
		
	}
	
	@Test
	public void editAdminTest() throws AdminException {
		Admin admin = new Admin(101,"vkm@gmail.com","Vishal Mawani","abcd2ne3j2");
		adminDao.addAdmin(admin);
		long adminId = 101;
		when(adminDao.editAdmin(adminId, admin)).thenReturn(true);
		assertEquals("Admin Updated", adminService.editAdmin(adminId, admin));
	}
	
	@Test 
	public void editAdminTests() {
		Admin admin = new Admin(101,"vkm@gmail.com","Vishal Mawani","abcd2ne3j2");
		adminDao.addAdmin(admin);
		long adminId = 102;
		when(adminDao.editAdmin(adminId, admin)).thenReturn(false);
		try {
			adminService.editAdmin(adminId,admin);
			
		} catch(Exception e) {
			assertEquals("Admin Not Found",e.getMessage());
		}
	}
	
	
}

 