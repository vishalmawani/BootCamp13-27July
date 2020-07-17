package com.cg.BookStore.Exception;

public class WrongCredentialsException extends RuntimeException{
	
	public WrongCredentialsException(String message)
	{
		super(message);
	}

}
