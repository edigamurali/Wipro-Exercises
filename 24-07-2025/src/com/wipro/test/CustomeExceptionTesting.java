package com.wipro.test;

import com.wipro.exception.InvalidMonthException;

public class CustomeExceptionTesting 
{
	public static void checkMonth(int month) throws InvalidMonthException
	{
		if(month>=1 && month<=12)
		{
			System.out.println("Month is valid");
		}
		else {
			throw new InvalidMonthException("Month is not valid");
		}
	}

	public static void main(String[] args) 
	{
		try {
			checkMonth(12);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}
