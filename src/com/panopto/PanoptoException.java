package com.panopto;

public class PanoptoException extends Exception 
{
	public PanoptoException(String message)
	{
		super(message);
	}
	
	public PanoptoException(String message, Exception innerException)
	{
		super(message);
		this.innerException = innerException;
	}
	
	public PanoptoException(String format, String[] params)
	{
		super(String.format(format, (Object[])params));
	}
	
	public Exception getInnerException()
	{
		return innerException;
	}
	
	private static final long serialVersionUID = 1L;
	
	private Exception innerException = null;
}