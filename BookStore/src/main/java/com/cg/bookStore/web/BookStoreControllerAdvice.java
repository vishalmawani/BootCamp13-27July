package com.cg.bookStore.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.bookStore.exceptions.AdminServiceException;
import com.cg.bookStore.exceptions.AdminServiceExceptionMessage;



@RestControllerAdvice
public class BookStoreControllerAdvice {

	@ExceptionHandler(value= {AdminServiceException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public AdminServiceExceptionMessage handleAdminServiceException(AdminServiceException exception) {
		return new AdminServiceExceptionMessage(exception.getMessage());
	}
	

	
}
