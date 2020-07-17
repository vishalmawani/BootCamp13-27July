package com.cg.bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.Admin;
import com.cg.bookstore.entities.CustomerInformation;
import com.cg.bookstore.entities.OrderInformation;
import com.cg.bookstore.entities.QueryResponseDTO;
import com.cg.bookstore.exceptions.ListNotFoundException;
import com.cg.bookstore.exceptions.UserNotFoundException;

@Repository
public class BookStoreDaoImp implements BookStoreDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public BookStoreDaoImp()
	{}
	
	@Override
	public List<Admin> retreiveList(int adminId) {
		// TODO Auto-generated method stub
		
		String Qstr="Select admin from Admin admin Where Not admin.adminId =: adminId";
		try {
		TypedQuery<Admin> query= entityManager.createQuery(Qstr,Admin.class).setParameter("adminId", adminId);
		return query.getResultList();
		}
		catch(Exception e)
		{
			throw new ListNotFoundException("The List you want to access does not exist");
		}
	}

	@Override
	public Admin getAdmin(int adminId) {
		// TODO Auto-generated method stub
		Admin admin=entityManager.find(Admin.class, adminId);
		return admin;
	}

	
	
//	public CustomerInformation getCustomerByEmail(String email)
//	{   CustomerInformation customer=null;
//		try {
//		String Qstr="Select customer From CustomerInformation customer Where customer.emailAddress=:email";
//		TypedQuery<CustomerInformation> query=entityManager.createQuery(Qstr, CustomerInformation.class).setParameter("email", email);
//		customer=query.getSingleResult();
//		}
//		catch(Exception e)
//		{
//			//throw a exception
//		}
//		return customer;
//	}
//	
//	public boolean getCustomerReviewStatus(int customerId)
//	{   //returns false if no review is found
//		return false;
//	}
//	
//	public boolean getOrderInformationStatus(int customerId)
//	{   //returns false if no order is found
//		
//		try {
//		String Qstr="Select order From OrderInformation order Join order.customerDetails customer Where customer.customerId=:customerId";
//		TypedQuery query = entityManager.createQuery(Qstr, OrderInformation.class);
//		query.getSingleResult();
//		}
//		catch(Exception e)
//		{
//			return false;
//		}
//		return true;
//	}
//	public void deleteCustomer(CustomerInformation customer)
//	{
//		entityManager.remove(customer);
//	}
	
	//todo check if setFirstresult throws any error
	@Override
	public QueryResponseDTO getAllCustomers(int pageNumber) {
		
		String queryToAllCustomers="SELECT customer FROM CustomerInformation customer WHERE customer.customerId>1 ORDER BY customerId DESC";
		
		TypedQuery<CustomerInformation> typedQueryForFetchingCustomers=entityManager.createQuery(queryToAllCustomers, CustomerInformation.class);
		
		TypedQuery<Integer> typedQueryForSize=entityManager.createNamedQuery("SELECT count(customer) FROM CustomerInformation customer", Integer.class);
		
		int totalCount=typedQueryForSize.getSingleResult();
		typedQueryForFetchingCustomers.setFirstResult((pageNumber-1)*10); 
		typedQueryForFetchingCustomers.setMaxResults(10);
		
		List<CustomerInformation> resultList=typedQueryForFetchingCustomers.getResultList();
		
		QueryResponseDTO queryResponse=new QueryResponseDTO();
		queryResponse.setCurrentPageNumber(pageNumber);
		queryResponse.setTotalNoOfPages(totalCount);
		queryResponse.setList(resultList);
		return queryResponse;
	}

}
