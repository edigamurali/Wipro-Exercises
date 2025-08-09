package com.wipro.annymousTest;

import java.util.Arrays;
import java.util.function.Function;

public class FractionalPart {

	public static void main(String[] args)
	{
				
				
		
		  Function<Double, Double> fraction=(num)-> { 
			  String[] number=num.toString().split(".");
		  System.out.println(Arrays.toString(number)); 
		  Double fractionNum=Double.valueOf(number[1]);
		  return fractionNum; 
		  };
		  System.out.println(fraction.apply(123.456));
		 
			
	}

}
