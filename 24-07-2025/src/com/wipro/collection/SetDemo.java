package com.wipro.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) 
	{
		Set<Integer> set=new HashSet();
		set.add(10);
		set.add(25);
		set.add(12);
		set.add(1);
		set.add(null);
		set.add(45);
		System.out.println(set);
		Set<Integer> set1=new LinkedHashSet();
		set1.add(10);
		set1.add(20);
		set1.add(12);
		set1.add(30);
		set1.add(45);
		set1.add(100);
		System.out.println(set1);
		Set<Integer> set2=new HashSet();
		for(Integer i:set)
		{
			if(!set1.contains(i))
			{
				set2.add(i);
			}
		}
		
		System.out.println(set2);
	}

}
