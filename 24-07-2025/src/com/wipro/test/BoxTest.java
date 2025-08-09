package com.wipro.test;

import com.wipro.collection.Box;

public class BoxTest {

	public static void main(String[] args) 
	{
		Box<Integer> box1=new Box();
		box1.add(10);
		Box<String> box2=new Box();
		box2.add("hi");
	}

}
