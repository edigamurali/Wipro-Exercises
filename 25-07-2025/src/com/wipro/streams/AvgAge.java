package com.wipro.streams;

import java.util.Arrays;
import java.util.List;

public class AvgAge {

	public static void main(String[] args) 
	{
		List<Integer> list=Arrays.asList(10,23,20,34,54,67,31,55);
		int sum=list.stream().reduce(0,(a,b)->a+b);
		System.out.println(sum/list.size());

	}

}
