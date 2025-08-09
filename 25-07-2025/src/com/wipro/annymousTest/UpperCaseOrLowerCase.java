package com.wipro.annymousTest;

import java.util.function.Predicate;

public class UpperCaseOrLowerCase {

	public static void main(String[] args) 
	{
		Predicate<String> isUpperCase=(name)->{
			String uppercase=name.toUpperCase();
			return name.equals(uppercase);
		};
		System.out.println(isUpperCase.test("murali"));
	}

}
