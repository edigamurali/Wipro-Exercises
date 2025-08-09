package com.wipro.anonymous;

import java.util.function.Predicate;

public class CheckingPolindrome {

	public static void main(String[] args) 
	{
		Predicate<String> isPalindrome = (name) ->
		{
			String polindrome=new StringBuilder(name).reverse().toString();
			return polindrome.equalsIgnoreCase(name);
	    };

	    System.out.println(isPalindrome.test("mom"));

	}

}
