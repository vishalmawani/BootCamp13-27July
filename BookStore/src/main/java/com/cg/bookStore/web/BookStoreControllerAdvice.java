package com.cg.bookStore.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.bookStore.exceptions.BookStoreServiceException;
import com.cg.bookStore.exceptions.BookStoreServiceExceptionMessage;



@RestControllerAdvice
public class BookStoreControllerAdvice {

	@ExceptionHandler(value= {BookStoreServiceException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public BookStoreServiceExceptionMessage handleAdminServiceException(BookStoreServiceException exception) {
		return new BookStoreServiceExceptionMessage(exception.getMessage());
	}
	

	
}
