package com.wipro.exception;

public class CurrencyChanging 
{

	 public static int changeCurrency(int number) throws NumberFormatException 
	 {
	        if (number == 0) {
	            throw new NumberFormatException("Invalid Number");
	        }
	        return number * 80;
	    }
	 public static void main(String[] args) {
		 try {
	         int num = 0;  
	         int result = changeCurrency(num);
	         System.out.println("Converted currency: " + result);
	     } catch (NumberFormatException ex) {
	         System.out.println("Exception caught: " + ex.getMessage());
	     }
	}
}
