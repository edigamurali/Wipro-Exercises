package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.model.Employee;
import com.wipro.repo.EmpRepository;

@Service
public class EmpServiceImpl implements EmpServiceI {

    @Autowired
    private EmpRepository repo;

    @Override
    public List<Employee> getEmpDetails() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Employee saveEmployee(Employee emp) {
        return repo.save(emp);
    }

    @Override
    public void deleteEmployee(int id) {
        repo.deleteById(id);
    }
}
