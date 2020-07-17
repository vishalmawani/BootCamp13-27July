package com.cg.bookStore.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookStore.dao.AdminDaoI;
import com.cg.bookStore.entities.Admin;
import com.cg.bookStore.exceptions.AdminServiceException;

@Transactional
@Service
public class AdminService implements AdminServiceI{

	@Autowired
	AdminDaoI adminDaoI;
	
	String regexForPassword = "^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$";
	
	String regexForEmail="^[a-zA-Z0-9_+&*-]+(?:\\."+ 
            "[a-zA-Z0-9_+&*-]+)*@" + 
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
            "A-Z]{2,7}$";
	
	Pattern patternForPassword = Pattern.compile(regexForPassword);
	Pattern patternForEmail=Pattern.compile(regexForEmail); 
	@Override
	public Admin addAdmin(Admin admin) throws AdminServiceException {
		
		if(admin.getEmail().equals("") || (admin.getEmail().length()<11 || admin.getEmail().length()>64))
		{
//			Matcher matcher = patternForEmail.matcher(admin.getEmail());
//			if(matcher.matches()==false) 
//			{
//				throw new AdminServiceException("Email Can't Be Empty");
//			}
		}
		else if(admin.getFullName().equals("") || (admin.getFullName().length()<8 || admin.getFullName().length()>30) )
		{
			throw new AdminServiceException("Name Can't Be Empty having length between 8 and 30");
		}
		
		
		else if(admin.getPassword().equals("") || (admin.getPassword().length()<8 || admin.getPassword().length()>16))
		{
			Matcher matcher = patternForPassword.matcher(admin.getPassword());
		
			if(matcher.matches()==false)
			{
			throw new AdminServiceException("Password Must have  alteast one special ,one numeric, one capital and length between 8 to 16 ");
		
			}
		}
		else
		{
		adminDaoI.addAdmin(admin);
		}
		return admin;
	}

	
}
