package com.wipro.anonymous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wipro.annymousTest.Employee;

public class SortEmployee {

	public static void main(String[] args) 
	{
		Employee emp1=new Employee("Wipro123","Murali", 24,100000.0);
		Employee emp2=new Employee("Wipro345","Ram", 50,50000.0);
		Employee emp3=new Employee("Wipro997","Janu", 34,90000.0);
		Employee emp4=new Employee("Wipro786","Aravind",30,10000.0);
		Employee emp5=new Employee("Wipro876","Sahithi",21,70000.0);

		
		List<Employee> list=new ArrayList();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		
	}

}
