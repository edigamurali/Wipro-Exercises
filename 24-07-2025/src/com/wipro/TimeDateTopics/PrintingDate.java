package com.wipro.TimeDateTopics;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;


public class PrintingDate
{
	public static void main(String[] args) 
	{
		LocalDate ld=LocalDate.of(2023,Month.NOVEMBER, 01);
		DateTimeFormatter dtd=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println(ld.format(dtd));
	}
}
