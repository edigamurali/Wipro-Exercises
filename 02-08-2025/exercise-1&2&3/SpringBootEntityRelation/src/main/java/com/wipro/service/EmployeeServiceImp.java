package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.entity.Employee;
import com.wipro.repo.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeeServiceI {

	@Autowired
	EmployeeRepo employeeRepo;
	@Override
	public void saveEmployee(Employee emp) {
		
		employeeRepo.save(emp);
	}

	@Override
	public List<Employee> findAllEmployee() {
		
		return employeeRepo.findAll();
	}

}
