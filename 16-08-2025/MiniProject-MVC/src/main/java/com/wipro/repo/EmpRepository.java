package com.wipro.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.model.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
}
