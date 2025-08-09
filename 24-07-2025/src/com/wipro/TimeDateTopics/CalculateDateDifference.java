package com.wipro.TimeDateTopics;

import java.time.LocalDate;
import java.util.Scanner;

public class CalculateDateDifference 
{
	public static void getDateDiff(LocalDate date1,LocalDate date2)
	{
		 // Swap if date1 is after date2
        if (date1.isAfter(date2)) {
            LocalDate temp = date1;
            date1 = date2;
            date2 = temp;
        }
        int years = date2.getYear() - date1.getYear();//1
        int months = date2.getMonthValue() - date1.getMonthValue();//-11
        int days = date2.getDayOfMonth() - date1.getDayOfMonth();//-26
        
		 if (days < 0) {
	            date2 = date2.minusMonths(1);  // 2024-12-01
	            int daysInPreviousMonth = date2.lengthOfMonth();//31
	            days += daysInPreviousMonth;//-26+31=5days
	            months--;//-12
	        }
		
		if (months < 0) {
            months += 12;//-12+12=1
            years--;//1--=0

        }
		System.out.println(years + " years, " + months + " months, " + days + " days");

		
	}
	public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first date (yyyy-mm-dd): ");//2024-12-31
        LocalDate date1 = LocalDate.parse(sc.next());

        System.out.print("Enter second date (yyyy-mm-dd): ");//2025-01-05
        LocalDate date2 = LocalDate.parse(sc.next());
		getDateDiff(date1 , date2);

	}

}
