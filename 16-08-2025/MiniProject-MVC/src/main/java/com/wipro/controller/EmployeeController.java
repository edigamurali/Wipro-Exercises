package com.wipro.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.model.Employee;
import com.wipro.service.EmpServiceImpl;

@Controller
public class EmployeeController {

    @Autowired
    private EmpServiceImpl service;

    @RequestMapping("/")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/generate")
    public String showEmpDetails(Map<String,Object> map) {
        List<Employee> list = service.getEmpDetails();
        map.put("empList", list);
        return "show_emp";
    }

    @GetMapping("/add")
    public String showAddForm(Map<String,Object> map) {
        map.put("employee", new Employee());
        return "register_emp";
    }

    @PostMapping("/add")
    public String saveEmployee(@ModelAttribute("employee") Employee emp) {
        service.saveEmployee(emp);
        return "redirect:/generate";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable int id, Map<String,Object> map) {
        Employee emp = service.getEmployeeById(id);
        map.put("employee", emp);
        return "edit_emp";
    }

    @PostMapping("/edit")
    public String updateEmployee(@ModelAttribute("employee") Employee emp) {
        service.saveEmployee(emp);
        return "redirect:/generate";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return "redirect:/generate";
    }
}
