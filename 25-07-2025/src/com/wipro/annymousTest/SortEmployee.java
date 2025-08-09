package com.wipro.annymousTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SortEmployee {

	public static void main(String[] args) 
	{
		Employee emp1=new Employee("Wipro123","Murali", 24,100000.0);
		Employee emp2=new Employee("Wipro345","Ram", 50,50000.0);
		Employee emp3=new Employee("Wipro997","Janu", 34,90000.0);
		Employee emp4=new Employee("Wipro786","Aravind",30,10000.0);
		Employee emp5=new Employee("Wipro876","Sahithi",21,70000.0);

		
		List<Employee> list=new CopyOnWriteArrayList();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		Collections.sort(list,Collections.reverseOrder());
		System.out.println("Before removing emp sal>80000 emp count "+list.size());
		System.out.println(list);
		for(Employee data:list)
		{
			if(data.getEmpSalary()>80000)
			{
				list.remove(data);
			}
		}
		System.out.println("after removing emp sal>80000 emp count "+list.size());
		System.out.println(list);

	}

}
