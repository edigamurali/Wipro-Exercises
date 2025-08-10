package com.wipro.methodReference;

import java.util.Arrays;
import java.util.List;

public class EmployeeTest {

	public static void main(String[] args) 
	{
		Employee e1=new Employee("John",25,40000);
		Employee e2=new Employee("Alice",35,60000);
		Employee e3=new Employee("Bob",40,70000);
		Employee e4=new Employee("Charlie",20,30000);
		Employee e5=new Employee("David",38, 55000);
		List<Employee> list=Arrays.asList(e1,e2,e3,e4,e5);
		list.stream().filter(emp->emp.getAge()>30&&emp.getSalary()>50000)
		.forEach(System.out::println);

	}

}
