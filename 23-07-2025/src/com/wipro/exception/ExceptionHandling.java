package com.wipro.exception;

public class ExceptionHandling 
{
	public static void main(String[] args) {
		String fName=null;
		try {
			fName=fName.toUpperCase();
		}
		catch (NullPointerException ex) {
			System.out.println("FName is null please Initialize with some name");
		}
	}
}
