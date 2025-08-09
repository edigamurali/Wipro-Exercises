package com.wipro.oop;

public class Dog extends Animal{

	public Dog(int sleepTime) {
		super(sleepTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eating() {
		// TODO Auto-generated method stub
		System.out.println("Im dog I can eat");
	}

	@Override
	public void sleeping() {
		// TODO Auto-generated method stub
		System.out.println("Im dog I can sleep for "+sleepTime+"hr");
		
	}

	@Override
	public void walking() {
		// TODO Auto-generated method stub
		System.out.println("Im dog I can walk");
	}

}
