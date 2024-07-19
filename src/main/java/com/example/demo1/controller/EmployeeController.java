package com.example.demo1.controller;

import com.example.demo1.entity.Employee;
import com.example.demo1.sevice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployee()
    {
        return employeeService.getAllEmployee();
    }

    @PostMapping( "/addEmployee")
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee newEmployee)
    {
        return employeeService.addEmployee(newEmployee);
    }
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
    {
        return employeeService.updateEmployee(id,employee);
    }
}
