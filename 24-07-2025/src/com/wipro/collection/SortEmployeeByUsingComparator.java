package com.wipro.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortEmployeeByUsingComparator {

	public static void main(String[] args) 
	{
		Employee emp1=new Employee("Wipro123","Murali", 24,1000.0);
		Employee emp2=new Employee("Wipro345","Ram", 50,1100.0);
		Employee emp3=new Employee("Wipro997","Janu", 34,1700.0);
		Employee emp4=new Employee("Wipro786","Aravind",30,100.0);
		
		List<Employee> list=new ArrayList();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		System.out.println("sorting by empname");
		Collections.sort(list,new SortByEmpName());
		System.out.println(list);
		System.out.println("sorting by age");
		Collections.sort(list,new SortByEmpAge());
		System.out.println(list);
		System.out.println("sorting by id");
		Collections.sort(list,new SortByEmpId());
		System.out.println(list);


		
		
		
	}

}
