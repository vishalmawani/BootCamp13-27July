package com.cg.bookStore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.bookStore.exception.UserException;
import com.cg.bookStore.service.BookStoreService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DeleteTests {
	@Autowired
	private BookStoreService bookStoreService;
	
	
	@Test
	public void deleteUser() throws UserException
	{
		boolean expectedValue = true;
		boolean actualValue= bookStoreService.deleteUser(302);
		assertEquals(expectedValue,actualValue);
	}
	
	@Test
	public void deleteUser1() throws UserException
	{
		boolean expectedValue = true;
		boolean actualValue= bookStoreService.deleteUser(301);
		assertEquals(expectedValue,actualValue);
	}
	
	
//	@Test
//	public void deleteBook1() throws BookException
//	{
//		String expectedValue = "Book does not exist!";
//		String actualValue= service.deleteBook(2);
//		assertEquals(expectedValue,actualValue);
//	}

}