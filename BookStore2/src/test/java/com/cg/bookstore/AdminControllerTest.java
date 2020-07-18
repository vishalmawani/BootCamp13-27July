package com.cg.bookstore;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.bookstore.controller.AdminController;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdminControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private AdminController adminController;
	
	@Before
	public void setUp()throws Exception{
		mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
	}
	
	@Test
	public void testAddAdmin() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/addAdmin"))
		.andExpect(MockMvcResultMatchers.content().string("Admin Added"));
	}
}
