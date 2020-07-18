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
import com.cg.bookStore.exception.UserException;

@Transactional
@Repository
public class BookStoreDaoImplementation implements BookStoreDao{
	

	@PersistenceContext
	EntityManager entityManager;
	

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
	public boolean deleteUser(int adminId) throws UserException{
		
		if(entityManager.contains(entityManager.find(Admin.class, adminId)))
		{
		Admin user = entityManager.find(Admin.class, adminId);
		entityManager.remove(user);
		return true;
		}
		else
		{
			throw new UserException("User Not found");
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
	public CustomerInformation getCustomerByEmail(String email) throws UserException{
		
		CustomerInformation customer=null;
		try {
			
			String Qstr="Select customer From CustomerInformation customer Where customer.emailAddress=:email";
			TypedQuery<CustomerInformation> query=entityManager.createQuery(Qstr, CustomerInformation.class).setParameter("email", email);
			customer=query.getSingleResult();
		}
		catch(Exception e){
			
			throw new UserException("Customer not found.");
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
	
	public boolean getCustomerReviewStatus(int customerId){
		
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
	public boolean getOrderInformationStatus(int customerId){ 
		
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
	public boolean deleteCustomer(CustomerInformation customer){
		
		entityManager.remove(customer);
		return true;
	}
		
}
