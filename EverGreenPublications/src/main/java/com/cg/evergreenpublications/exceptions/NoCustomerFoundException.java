package com.cg.evergreenpublications.exceptions;

public class NoCustomerFoundException extends RuntimeException {

	private String log;
	
	public NoCustomerFoundException(String log)
	{
	 this.log=log;	
	}
	public String getLog()
	{
		return this.log;
	}
}
