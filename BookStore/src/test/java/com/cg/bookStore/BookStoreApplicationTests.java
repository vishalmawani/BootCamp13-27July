package com.cg.bookstore;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.cg.bookstore.dao.BookStoreDao;
import com.cg.bookstore.service.BookStoreServiceImp;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookstoreApplicationTests {

	
	@Mock
	BookStoreDao bookStoredao;
	
	@InjectMocks
	private BookStoreServiceImp bookStoreService;
	
	
	

}
