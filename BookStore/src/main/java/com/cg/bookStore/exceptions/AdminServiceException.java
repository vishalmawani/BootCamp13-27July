package com.cg.bookStore.exceptions;

@SuppressWarnings("serial")
public class AdminServiceException extends Exception{

	String message;

	public AdminServiceException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
