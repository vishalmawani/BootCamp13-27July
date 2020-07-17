package com.cg.bookStore.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookStore.dao.BookStoreDaoI;
import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.entities.CustomerInformation;
import com.cg.bookStore.exceptions.AdminServiceException;

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
            + "(?=\\S+$).{8,20}$";
	
	
	Pattern patternForPassword = Pattern.compile(regexForPassword);
	
	@Override
	public String addAdmin(Admin admin) throws AdminServiceException {

		Query query=entityManager.createQuery("from Admin where email='"+admin.getEmail()+"'");
		List<Admin> list=query.getResultList();
		if(list.isEmpty()==false)
		{
			throw new AdminServiceException("Entered email id is already exists");
		}
		
		if(admin.getEmail().equals("") || (admin.getEmail().length()<11 || admin.getEmail().length()>64))
		{
            throw new AdminServiceException("Please Enter Valid Email Id");
		}
		
		else if(admin.getFullName().equals("") || (admin.getFullName().length()<8 || admin.getFullName().length()>30) )
		{
			throw new AdminServiceException("Name Can't Be Empty having length between 8 and 30");
		}
		
		
		else if(admin.getPassword().equals("") || (admin.getPassword().length()<8 || admin.getPassword().length()>16))
		{
			throw new AdminServiceException("Password shouldn't be empty having length between 8 to 16 ");

		}
		
		Matcher matcher = patternForPassword.matcher(admin.getPassword());
		
		System.out.println(matcher.matches());
	    if(matcher.matches()==false)
		{
		throw new AdminServiceException("Password Must have  alteast one special ,one numeric, one capital character");
		}
		bookStoreDaoI.addAdmin(admin);
		
		return "Admin Created";
	}

	
	
	
	
	
	@Override
	public String editAdmin(long adminId, Admin admin) throws AdminServiceException{
		if(bookStoreDaoI.editAdmin(adminId, admin))
			return "Admin updated";
		else
			throw new AdminServiceException("Admin not found.");
	}
	
	
	
	@Override
	public List<Admin> getUserList(long adminId) throws AdminServiceException {
		Admin admin=bookStoreDaoI.getAdmin(adminId);
		if(admin==null)
			throw new AdminServiceException("User might be removed or not available");
		List<Admin> userList;
		userList=bookStoreDaoI.retreiveList(adminId);
		return userList;
	}
	
//	
//	
//	@Override
//	public boolean save(CustomerInformation customerInfromation) {
//		return bookStoreDaoI.save(customerInfromation);
//	}
}
