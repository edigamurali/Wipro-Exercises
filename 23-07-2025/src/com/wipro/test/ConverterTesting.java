package com.wipro.test;

import com.wipro.oop.Converter;

public class ConverterTesting {

	public static void main(String[] args) 
	{
		Converter converter=new Converter();
		converter.convert(10);
		converter.convert(100,20);
		converter.convert(10.0);

	}

}
