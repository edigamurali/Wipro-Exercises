package com.wipro.annymousTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LengthOfArrayString {
	
	public static void main(String[] args) 
	{
		Function<List<String>,List<Integer>> lengths=(list)->
		{
			ArrayList<Integer>  lenghtsList=new ArrayList();
			for(String name:list)
			{
				 lenghtsList.add(name.length());
			}
			return lenghtsList;
		};
		List<Integer> list=lengths.apply(List.of("Ragunandan","MANASA","ram","bheem","murali","Sreee"));
		System.out.println(list);

	}
}
