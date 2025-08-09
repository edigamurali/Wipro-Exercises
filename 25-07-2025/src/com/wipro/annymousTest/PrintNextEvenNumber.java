package com.wipro.annymousTest;

import java.util.function.Consumer;

public class PrintNextEvenNumber {

	public static void main(String[] args) 
	{
			Consumer<Integer> nextEvenNumber=(number)->{
				System.out.println(number%2==0?number+2:number+1);
			};
			nextEvenNumber.accept(9);

	}

}
