package com.wipro.test;

import com.wipro.oop.Bird;
import com.wipro.oop.Dog;
import com.wipro.oop.Human;

public class AnimalTesting 
{
	public static void main(String[] args) {
		Human human=new Human(8);
		human.eating();
		human.sleeping();
		human.walking();
		Bird bird=new Bird(10);
		bird.eating();
		bird.walking();
		bird.sleeping();
		Dog dog=new Dog(12);
		dog.eating();
		dog.walking();
		dog.sleeping();
	}
}
