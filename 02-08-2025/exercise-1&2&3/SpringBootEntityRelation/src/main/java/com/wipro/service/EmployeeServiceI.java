package com.wipro.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.wipro.entity.Employee;

public interface EmployeeServiceI {
	
	public void saveEmployee( Employee emp);
	public List<Employee> findAllEmployee();

}
