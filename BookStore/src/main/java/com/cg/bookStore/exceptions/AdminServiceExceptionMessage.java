package com.cg.bookStore.exceptions;

public class AdminServiceExceptionMessage {

	String message;

	public AdminServiceExceptionMessage(String message) {
		super();
		this.message = message;
	}

	public AdminServiceExceptionMessage() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
