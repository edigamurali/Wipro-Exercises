package com.wipro.service;

import java.util.List;

import com.wipro.model.Employee;

public interface EmpServiceI {
    List<Employee> getEmpDetails();
    Employee getEmployeeById(int id);
    Employee saveEmployee(Employee emp);
    void deleteEmployee(int id);
}
