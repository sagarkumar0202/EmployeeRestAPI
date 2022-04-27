package org.employee.exception;

public class idNotFoundException extends Exception 
{

	private String message;
	public idNotFoundException(String message)
	{
		super(message);
	}
}
