package com.cg.bookStore.exceptions;

public class BookStoreServiceExceptionMessage {

	String message;

	public BookStoreServiceExceptionMessage(String message) {
		super();
		this.message = message;
	}

	public BookStoreServiceExceptionMessage() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
