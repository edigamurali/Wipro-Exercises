package com.wipro.oop;

public class Human extends Animal{

	public Human(int sleepTime) {
		super(sleepTime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eating() {
		System.out.println("Im human I can eat");
		
	}

	@Override
	public void sleeping() {
		// TODO Auto-generated method stub
		System.out.println("Im human I can sleep for "+sleepTime+"hr");
	}

	@Override
	public void walking() {
		// TODO Auto-generated method stub
		System.out.println("Im human I can walk");
	}

}
