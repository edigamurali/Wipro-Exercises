package com.wipro.methodReference;

import java.util.Arrays;
import java.util.List;

public class StringMethodReference {

	public static void main(String[] args)
	{
		List<String> list=Arrays.asList("murali","ram","bheem","ziya","vishnu","anu");
		list.stream().sorted(String::compareTo).forEach(System.out::println);
	}

}
