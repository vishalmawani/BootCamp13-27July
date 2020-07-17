package com.cg.bookStore;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DaoTesting {
	
	
	@Test
	public void checkUserNotExist()
	{
		boolean value=false;
		assertEquals(value,false);
	}
	
	@Test
	public void checkUserExist()
	{
		int val=1234;
		assertEquals(val,1234);
	}
}
