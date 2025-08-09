package com.wipro.annymousTest;

import com.wipro.anonymous.Greet;

public class LambdaDemo {

	public static void main(String[] args) 
	{
		Greet greet=()->{
			System.out.println("Hello Lambda");
			};
		greet.sayHellow();

	}

}
