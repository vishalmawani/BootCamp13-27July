package com.cg.bookStore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.entities.CustomerReview;
import com.cg.bookStore.entities.OrderInformation;
import com.cg.bookStore.entities.QueryResponseDTO;
import com.cg.bookStore.exceptions.BookStoreServiceException;

@Transactional
@Repository
public class BookStoreDaoImp implements BookStoreDaoI{

	@PersistenceContext
	EntityManager entityManager;

	/**********************************************************************************
	* Method        addAdmin
	* Description   This method persist data of admin to database 
	* returns       it return nothing
	* Created By    Ashok Sharma 
	* Created on    17-July-2020
	 * @throws BookStoreServiceException
	**********************************************************************************/
	
	@Override
	public void addAdmin(Admin admin) {

		entityManager.persist(admin);
		
	}

	
	
	
	@Override
	public boolean editAdmin(int adminId, Admin admin) {
		Admin editAdmin = entityManager.find(Admin.class, adminId);
		if (editAdmin == null)
			return false;
		editAdmin.setEmail(admin.getEmail());
		editAdmin.setFullName(admin.getFullName());
		editAdmin.setPassword(admin.getPassword());
		entityManager.merge(editAdmin);
		return true;
	}
	
	
	
	
	@Override
	public List<Admin> retreiveList(int adminId) throws BookStoreServiceException {
		
		String Qstr="Select admin from Admin admin Where Not admin.adminId =: adminId";
		try {
		TypedQuery<Admin> query= entityManager.createQuery(Qstr,Admin.class).setParameter("adminId", adminId);
		return query.getResultList();
		}
		catch(Exception e)
		{
			throw new BookStoreServiceException("The List you want to access does not exist");
		}
	}

	@Override
	public Admin getAdmin(int adminId) {
		Admin admin=entityManager.find(Admin.class, adminId);
		return admin;
	}
	
	
	
	
	@Override
	public boolean save(CustomerInformation customer) {
		if(customer.getAddress()==null || customer.getCity()==null || customer.getCountry()==null || customer.getEmailAddress()==null || customer.getFullName()==null || 
				customer.getPassword()==null || customer.getPhoneNumber()==null || customer.getZipCode()==0  )
		{
			return false;
		}
		entityManager.persist(customer);
		return true;
		
	}
	
	
	
	
	/*---------------------------------------------------*/	
	
	@Override
	public void persistCustomer(CustomerInformation customer) {
		
		entityManager.persist(customer);
		
	}
	
	@Override
	public boolean checkCustomeByEmail(String emailAddress) {
		String checkquery="Select customer.emailAddress FROM Customer customer WHERE customer.emailAddress= :emailAddress";
		TypedQuery<String> query=entityManager.createQuery(checkquery,String.class).setParameter("emailAddress",emailAddress);
		try {
			
			query.getSingleResult();
		} catch(Exception exception) {
			
			return false;
		}
		return true;
	}
	
	@Override
	public CustomerInformation FindByCustomerEmail(String emailAddress) {
		
		String findquery="Select customer.emailAddress FROM Customer customer WHERE customer.emailAddress= :emailAddress";
		TypedQuery<CustomerInformation> query=entityManager.createQuery(findquery,CustomerInformation.class).setParameter("emailAddress",emailAddress);
		return query.getSingleResult();
	}
	
	@Override
	public CustomerInformation getCustomer(Integer customer_id) {
		CustomerInformation customer=entityManager.find(CustomerInformation.class, customer_id);
		return customer;
	}

	

	
	
	@Override
	public void persistAdmin(Admin admin) {
		entityManager.persist(admin);
		
	}

	@Override
	public boolean checkAdminByEmail(String email) {
		String checkquery="Select admin.email FROM Admin admin WHERE admin.email= :email";
		TypedQuery<String> query=entityManager.createQuery(checkquery,String.class).setParameter("email",email);
		try {
			
			query.getSingleResult();
			
		} catch(Exception exception) {
			
			return false;
		}
		
		return true;
	}
	
	@Override
	public Admin FindByAdminEmail(String email) {
		String findquery="Select admin.email FROM Admin admin WHERE admin.email= :email";
		TypedQuery<Admin> query=entityManager.createQuery(findquery,Admin.class).setParameter("email",email);
		return query.getSingleResult();
	}

	@Override
	public Admin getAdmin(Integer admin_id) {
		Admin admin=entityManager.find(Admin.class, admin_id);
		return admin;
	}

	/*---------------------------*/
	
	
	
	
	@Override
	public QueryResponseDTO getAllCustomers(int pageNumber) {
		
		String queryToAllCustomers="SELECT customer FROM CustomerInformation customer WHERE customer.customerId>1 ORDER BY customerId DESC";
		
		TypedQuery<CustomerInformation> typedQueryForFetchingCustomers=entityManager.createQuery(queryToAllCustomers, CustomerInformation.class);
				
		int totalCount=typedQueryForFetchingCustomers.getResultList().size();														//typedQueryForSize.getSingleResult();
		typedQueryForFetchingCustomers.setFirstResult((pageNumber-1)*10); 
		typedQueryForFetchingCustomers.setMaxResults(10);
		
		List<CustomerInformation> resultList=typedQueryForFetchingCustomers.getResultList();
		
		QueryResponseDTO queryResponse=new QueryResponseDTO();
		queryResponse.setCurrentPageNumber(pageNumber);
		queryResponse.setTotalNoOfPages(totalCount);
		queryResponse.setList(resultList);
		return queryResponse;
	}
	
	
	
	/********************************************************************************
	 * Method            deleteUser 
	 * Description       for checking whether the account exists or not and then
	 *                   deleting it
	 * returns boolean   returns true if account exists and gets deleted
	 *                   otherwise returns false if account does not exists 
	 * Created By        Vaishali Tiwari                   
	 * Created on        16-July-2020
	 
	 **********************************************************************************/
	@Override
	public boolean deleteUser(int adminId) throws BookStoreServiceException{
		
		if(entityManager.contains(entityManager.find(Admin.class, adminId)))
		{
		Admin user = entityManager.find(Admin.class, adminId);
		entityManager.remove(user);
		return true;
		}
		else
		{
			throw new BookStoreServiceException("User Not found");
		}
	
	}
		


	/********************************************************************************
	 * Method            getCustomerByEmail 
	 * Description       for getting the customer's detail by email id
	 * return            returns the customer details if account exists
	 *                   otherwise throws exception if account does not exists 
	 * Created By        Vaishali Tiwari                   
	 * Created on        16-July-2020
	 
	 **********************************************************************************/

	@Override
	public CustomerInformation getCustomerByEmail(String email) throws BookStoreServiceException {
		CustomerInformation customer=null;
		try {
			
			String Qstr="Select customer From CustomerInformation customer Where customer.emailAddress=:email";
			TypedQuery<CustomerInformation> query=entityManager.createQuery(Qstr, CustomerInformation.class).setParameter("email", email);
			customer=query.getSingleResult();
		}
		catch(Exception e){
			
			throw new BookStoreServiceException("Customer not found.");
		}
		return customer;
	}



	/********************************************************************************
	 * Method            getCustomerReviewStatus 
	 * Description       for getting the customer's review status
	 * returns boolean   returns true if customer has provided a review otherwise 
	 *                   returns false
	 * Created By        Vaishali Tiwari                   
	 * Created on        16-July-2020
	 
	 **********************************************************************************/

	@Override
	public boolean getCustomerReviewStatus(int customerId) {
		List<CustomerReview> reviewList=null;
		try{
			String Qstr="Select review From CustomerReview review Where review.customerId=:customerId";
		    TypedQuery<CustomerReview> query = entityManager.createQuery(Qstr,CustomerReview.class).setParameter("customerId",customerId);
		    reviewList=query.getResultList();
		}
		catch(Exception e){  
				
			return false;
			
		}
		if(reviewList.isEmpty()){
			
				return false;
		}
		
			return true;
	}



	/********************************************************************************
	 * Method            getOrderInformationStatus 
	 * Description       for getting the customer's order detail
	 * returns boolean   returns true if order status is Processing or Shipped 
	 *                   otherwise returns false if order status is completed
	 * Created By        Vaishali Tiwari                   
	 * Created on        16-July-2020
	 
	 **********************************************************************************/

	@Override
	public boolean getOrderInformationStatus(int customerId) {
		String status;
		
		try {
			String Qstr="Select bookStoreOrder From OrderInformation bookStoreOrder Join bookStoreOrder.customerDetails customer Where customer.customerId=:customerId";
			TypedQuery<OrderInformation> query = entityManager.createQuery(Qstr, OrderInformation.class).setParameter("customerId", customerId);
			status=query.getSingleResult().getOrderStatus();
		}
		catch(Exception e){
			
			return false;
		}
		if(status.equals("Completed"))
		{
			return false;
		}
		return true;
	}
		

	/********************************************************************************
	 * Method            deleteCustomer 
	 * Description       for deleting Customer account
	 * returns boolean   returns true if account gets deleted
	 * Created By        Vaishali Tiwari                   
	 * Created on        16-July-2020
	 
	 **********************************************************************************/
	
	@Override
	public boolean deleteCustomer(CustomerInformation customer) {
		entityManager.remove(customer);
		return true;
	}

}
