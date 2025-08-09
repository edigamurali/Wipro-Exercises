package com.wipro.collection;

import java.util.Comparator;

public class SortByEmpAge implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		
		Double d1=Double.valueOf(o1.getEmpAge());
		Double d2=Double.valueOf(o2.getEmpAge());
		return d1.compareTo(d2);
	}

}
