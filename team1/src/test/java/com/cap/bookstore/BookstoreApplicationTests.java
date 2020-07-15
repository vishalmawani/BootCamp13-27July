package com.cap.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookstoreApplicationTests {

	@Test
	void checkTest() {
		assertTrue(true);
	}
	
	@Test
	void TC_01()
	{
		/* a list would have returned with the users objects present in it 
		 * to check the validity of the. we can compare that list with a predefined correct list
		 * using seertThat
		 */
		List<String> actual = Arrays.asList("fee", "fi", "foe");
		  List<String> expected = Arrays.asList("fee", "fi", "foe");
		//assertThat(actual, is(expected));
		  assertEquals(actual,expected);
	}

}
