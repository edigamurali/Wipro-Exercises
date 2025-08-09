package com.wipro.streams;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsDemoStrings 
{
	public static void main(String[] args) 
	{
		List<String> list=List.of("Ram","Jahnavi","mahesh","janu","jeevan","raja");
		List<String> outputList=list.stream()
								.filter(s->s.toLowerCase().contains("ja"))
								.collect(Collectors.toList());
		System.out.println(outputList);
	}
}
