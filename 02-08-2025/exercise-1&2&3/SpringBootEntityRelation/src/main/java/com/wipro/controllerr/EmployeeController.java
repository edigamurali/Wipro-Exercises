package com.wipro.controllerr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Employee;
import com.wipro.service.EmployeeServiceImp;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceImp empService;
	
	@PostMapping
	public void saveEmployee(@RequestBody Employee emp)
	{
		empService.saveEmployee(emp);
	}
	
	@GetMapping
	public List<Employee> findAllEmployees()
	{
		return empService.findAllEmployee();
	}
}
