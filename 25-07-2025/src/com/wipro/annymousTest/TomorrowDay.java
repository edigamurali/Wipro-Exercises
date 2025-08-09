package com.wipro.annymousTest;

import java.time.LocalDate;
import java.util.function.Supplier;

public class TomorrowDay {

	public static void main(String[] args) 
	{
		Supplier<String> tomorrowDay=()->{
			LocalDate date=LocalDate.now();
			String day=date.getDayOfWeek().plus(1).toString();
;			return day;
		};
		System.out.println(tomorrowDay.get());
		
	}

}
