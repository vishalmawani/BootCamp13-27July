
package com.cg.bookStore.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bookStore.dao.BookStoreDaoI;
import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.entities.QueryResponseDTO;
import com.cg.bookStore.exceptions.BookStoreServiceException;

@Transactional
@Service
public class BookStoreServiceImp implements BookStoreServiceI{

	@Autowired
	BookStoreDaoI bookStoreDaoI;
	
	@PersistenceContext
	EntityManager entityManager;
	
	String regexForPassword = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,16}$";
	
	
	Pattern patternForPassword = Pattern.compile(regexForPassword);
	
	/**********************************************************************************
	* Method        addAdmin
	* Description   This method will check all the validation and Exception if entered
	*                 details are correct then only it will send data to dao layer
	* returns       This method return string to tell the admn if another admin is created or not.
	* Created By    Ashok Sharma 
	* Created on    17-July-2020
	 * @throws BookStoreServiceException
	**********************************************************************************/
	
	@Override
	public String addAdmin(Admin admin) throws BookStoreServiceException {

		Query query=entityManager.createQuery("from Admin where email='"+admin.getEmail()+"'");
		
		@SuppressWarnings("unchecked")
		List<Admin> list=query.getResultList();
		if(list.isEmpty()==false)
		{
			throw new BookStoreServiceException("Entered email id is already exists");
		}
		
		if(admin.getEmail().equals("") || (admin.getEmail().length()<11 || admin.getEmail().length()>64))
		{
            throw new BookStoreServiceException("Please Enter Valid Email Id");
		}
		
		else if(admin.getFullName().equals("") || (admin.getFullName().length()<8 || admin.getFullName().length()>30) )
		{
			throw new BookStoreServiceException("Name Can't Be Empty having length between 8 and 30");
		}
		
		
		else if(admin.getPassword().equals("") || (admin.getPassword().length()<8 || admin.getPassword().length()>16))
		{
			throw new BookStoreServiceException("Password shouldn't be empty having length between 8 to 16 ");

		}
		
		Matcher matcher = patternForPassword.matcher(admin.getPassword());
		
		System.out.println(matcher.matches());
	    if(matcher.matches()==false)
		{
		throw new BookStoreServiceException("Password Must have  alteast one special ,one numeric, one capital character");
		}
	    bookStoreDaoI.addAdmin(admin);
	    return "New Admin Created Successfully";
		
	}

	
	
	
	@Override
	public String editAdmin(int adminId, Admin admin) throws BookStoreServiceException{
		if(bookStoreDaoI.editAdmin(adminId, admin))
			return "Admin updated";
		else
			throw new BookStoreServiceException("Admin not found.");
	}
	
	
	
	@Override
	public List<Admin> getUserList(int adminId) throws BookStoreServiceException {
		Admin admin=bookStoreDaoI.getAdmin(adminId);
		if(admin==null)
			throw new BookStoreServiceException("User might be removed or not available");
		List<Admin> userList;
		userList=bookStoreDaoI.retreiveList(adminId);
		return userList;
	}
	
	
	
	@Override
	public boolean save(CustomerInformation customerInfromation) {
		return bookStoreDaoI.save(customerInfromation);
	}
	
	
	
	
	@Override
	public Integer loginCustomer(String email, String password) throws BookStoreServiceException {
		
		if(!bookStoreDaoI.checkCustomeByEmail(email))
				throw new BookStoreServiceException("Customer is not registered with this email");
		
		
		CustomerInformation customer=bookStoreDaoI.FindByCustomerEmail(email);
		
		if(customer.getPassword().equals(password)==false)
				throw new BookStoreServiceException("The password does not match the Email provided");
			
		return customer.getCustomerId();
	}
	
	

	@Override
	public Integer loginAdmin(String email, String password) throws BookStoreServiceException {
		if(!bookStoreDaoI.checkAdminByEmail(email))
				throw new BookStoreServiceException("Admin is not registered with this email");
		
		Admin admin=bookStoreDaoI.FindByAdminEmail(email);
		
		if(admin.getPassword().equals(password)==false)
				throw new BookStoreServiceException("Admin is not registered with this email");
		return admin.getAdminId();
	}

	
	
	
	
	
	@Override
	public QueryResponseDTO getAllCustomers(String adminEmail, String adminPassword, int adminId,
			int pageNumber) throws BookStoreServiceException {
		if(pageNumber>0)
		{
			if(adminId>0)
			{
					Admin admin=bookStoreDaoI.getAdmin(adminId);
					if(admin==null)
					{
						throw new BookStoreServiceException("Invalid credentials!");
					}
					else if(admin.getEmail().equals(adminEmail) && admin.getPassword().equals(adminPassword))
					{
						return bookStoreDaoI.getAllCustomers(pageNumber);
					}
					else
					{
						throw new BookStoreServiceException("Invalid Credentials!");
					}
			}
			else
			{
				throw new BookStoreServiceException("Credentials are invalid");
			}
		}
		else
		{
			throw new BookStoreServiceException("Invalid page numnber");
		}
	}

	
	/********************************************************************************
	 * Method            deleteUser 
	 * Description       for deleting User account
	 * Created By        Vaishali Tiwari                   
	 * Created on        16-July-2020
	 
	 **********************************************************************************/
	
	
	@Override
	public boolean deleteUser(int adminId) throws BookStoreServiceException
	{
		return bookStoreDaoI.deleteUser(adminId);
	}
	
	/********************************************************************************
	 * Method            deleteCustomer 
	 * Description       for deleting Customer account
	 * Created By        Vaishali Tiwari                   
	 * Created on        16-July-2020
	 
	 **********************************************************************************/
	
	@Override
	public boolean deleteCustomer(String email) throws BookStoreServiceException
	{
		CustomerInformation customer=bookStoreDaoI.getCustomerByEmail(email);
		boolean customerReviewStatus = bookStoreDaoI.getCustomerReviewStatus(customer.getCustomerId());
		
		if(customerReviewStatus==true)
		{
			throw new BookStoreServiceException("Review found");
		}
		
		boolean orderInformationStatus = bookStoreDaoI.getOrderInformationStatus(customer.getCustomerId());
		
		if(orderInformationStatus==true)
		{
			throw new BookStoreServiceException("Active Order");
		}
		
		return bookStoreDaoI.deleteCustomer(customer);
	}
	
	
}
	

