package com.panopto;

public class PanoptoFatalException extends Exception 
{
	public PanoptoFatalException(String message)
	{
		super(message);
	}
	
	public PanoptoFatalException(String message, Exception innerException)
	{
		super(message);
		this.innerException = innerException;
	}
	
	public PanoptoFatalException(String format, String[] params)
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
