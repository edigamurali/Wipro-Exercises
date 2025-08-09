package com.wipro.TimeDateTopics;

import java.time.LocalDate;

public class CalculateAge {
	
	public static int getAge(LocalDate dt)
	{
		int birthYear=dt.getYear();
		int currentYear=dt.now().getYear();
		int age=currentYear-birthYear;
		return age;
	}
	
	public static void main(String[] args) {
		LocalDate date=LocalDate.of(2001,05,03);
		System.out.println(getAge(date));
	}

}
