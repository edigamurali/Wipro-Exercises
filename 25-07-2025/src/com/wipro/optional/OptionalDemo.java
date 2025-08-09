package com.wipro.optional;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) 
	{
		Optional<Integer> obj=Optional.ofNullable(10);
		if(obj.isPresent())
			System.out.println(obj.get());
		int defaultValue=obj.orElse(20);
		System.out.println(defaultValue);

	}

}
