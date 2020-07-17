package com.cg.bookStore;

import javax.swing.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.exceptions.AdminServiceException;
import com.cg.bookStore.service.BookStoreServiceI;
import com.cg.bookStore.web.BookStoreController;

@RunWith(SpringRunner.class)
@WebMvcTest(value=BookStoreController.class)
public class AddAdminTestCases {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookStoreServiceI adminServie;
	
	@Test
	public void checkNameEmptyValue() throws Exception
	{
		String adminJson= "{\r\n" + 
				"    \"fullName\": \"\",\r\n" + 
				"    \"email\": \"efsfsf@gmail.com\",\r\n" + 
				"    \"password\": \"dgdgryyu1@S\"\r\n" + 
				"    }";
		String expectedResult="Name Can't Be Empty having length between 8 and 30";
		Mockito.when(adminServie.addAdmin(Mockito.any(Admin.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/addAdmin").accept(MediaType.APPLICATION_JSON).content(adminJson).contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
				.string("Name Can't Be Empty having length between 8 and 30")).andDo(MockMvcResultHandlers.print());
				
		
	}
	
	@Test
	public void checkEmailEmptyValue() throws Exception
	{
		String adminJson= "{\r\n" + 
				"    \"fullName\": \"qwqerytrt\",\r\n" + 
				"    \"email\": \"\",\r\n" + 
				"    \"password\": \"dgdgryyu1@S\"\r\n" + 
				"    }";
		String expectedResult="Please Enter Valid Email";
		Mockito.when(adminServie.addAdmin(Mockito.any(Admin.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/addAdmin").accept(MediaType.APPLICATION_JSON).content(adminJson).contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
				.string("Please Enter Valid Email")).andDo(MockMvcResultHandlers.print());
				
		
	}
	
	
	@Test
	public void checkPasswordEmptyValue() throws Exception
	{
		String adminJson= "{\r\n" + 
				"    \"fullName\": \"qwqerytrt\",\r\n" + 
				"    \"email\": \"efsfsf@gmail.com\",\r\n" + 
				"    \"password\": \"dgdgryyu1@S\"\r\n" + 
				"    }";
		String expectedResult="Password shouldn't be empty having length between 8 to 16";
		Mockito.when(adminServie.addAdmin(Mockito.any(Admin.class))).thenReturn(expectedResult);
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/addAdmin").accept(MediaType.APPLICATION_JSON).content(adminJson).contentType(MediaType.APPLICATION_JSON);
		mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content()
				.string("Password shouldn't be empty having length between 8 to 16")).andDo(MockMvcResultHandlers.print());
				
		
	}
	
}
