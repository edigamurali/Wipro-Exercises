package com.wipro.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {

	public static void main(String[] args) 
	{
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		System.out.println("Before removing element  "+list);
		list.remove(2);
		System.out.println("After removing element  "+list);
		list.add(1);
		System.out.println("After adding element  ");
		Iterator<Integer> iterator=list.iterator();
		while(iterator.hasNext())
		{
			System.out.print(iterator.next()+" ");
		}

	}

}
