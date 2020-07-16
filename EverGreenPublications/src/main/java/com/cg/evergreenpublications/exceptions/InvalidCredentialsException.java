package com.cg.evergreenpublications.exceptions;

public class InvalidCredentialsException extends RuntimeException {

private String log;
	
	public InvalidCredentialsException(String log)
	{
	 this.log=log;	
	}
	public String getLog()
	{
		return this.log;
	}
}
