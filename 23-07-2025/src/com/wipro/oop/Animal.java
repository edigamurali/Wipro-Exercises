package com.wipro.oop;

public abstract class Animal
{
	int sleepTime;
	
	public abstract void eating();
	public abstract void sleeping();
	public abstract void walking();
	
	
	public Animal(int sleepTime) {
		super();
		this.sleepTime = sleepTime;
	}
	@Override
	public String toString() {
		return "Animal [sleepTime=" + sleepTime + "]";
	}
	
	
	
}
