package com.wipro.TimeDateTopics;

import java.time.LocalDate;
import java.util.Scanner;

public class LeapYearOrNot {
    public static String isLeapYear(LocalDate ld) {
        int y = ld.getYear();

        // ✅ Correct leap year logic
        if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
            return "Leap Year";
        } else {
            return "Not Leap Year";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter date in YYYY-MM-DD format:");
        LocalDate date = LocalDate.parse(sc.next());  // Input: 2024-04-20
        System.out.println(isLeapYear(date));         // Output: Leap Year
        sc.close();
    }
}
