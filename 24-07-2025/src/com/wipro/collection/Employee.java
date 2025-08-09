package com.wipro.collection;

import java.util.Comparator;

public class Employee implements Comparable<Employee>
{
	String empId;
	String empName;
	int empAge;
	double empSalary;
	public Employee(String empId, String empName, int empAge, double empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empSalary = empSalary;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empSalary=" + empSalary
				+ "]";
	}
	@Override
	public int compareTo(Employee other) {
		Double d1=Double.valueOf(this.getEmpSalary());
		Double d2=Double.valueOf(other.getEmpSalary());
		return d1.compareTo(d2);
		//return this.getEmpName().compareTo(other.getEmpName());
	}
	
	
	
	
}
