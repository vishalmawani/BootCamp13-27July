package com.cg.evergreenpublications.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import com.cg.evergreenpublications.dao.ListAllCustomersDAO;
import com.cg.evergreenpublications.entity.CustomerInformation;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ListAllCustomersServiceImplTests {

	@MockBean
	private ListAllCustomersDAO listAllCustomersDao;
	
	@Autowired
	private ListAllCustomersServiceImpl listAllCustomersService;
	
	// todo do this if add actual data
	@Test
	public void testGetAllCustomersInService()
	{
		List<CustomerInformation> list=new ArrayList<>(5);
	    Page<CustomerInformation> pageList=new PageImpl(list);
	    when(listAllCustomersDao.getAllCustomers(PageRequest.of(1,5,Sort.by(Direction.DESC, "customerId")))).thenReturn(pageList);
		assertEquals(listAllCustomersService.getAllCustomers("aravin123@gmail.com", "aravind@123", 101, 0).toList().size(),5);
	    verify(listAllCustomersDao).getAllCustomers(PageRequest.of(1,5,Sort.by(Direction.DESC, "customerId")));
	}
	
	//todo add test case for checking inavlid admin credentials and pagenumber
}
