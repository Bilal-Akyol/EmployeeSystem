package com.example.demo1.controller;

import com.example.demo1.database.dto.requets.EmployeeRequets;
import com.example.demo1.database.dto.response.EmployeeResponse;
import com.example.demo1.entity.entities.Employee;
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
    public List<EmployeeResponse> getAllEmployee()
    {
        return employeeService.getAllEmployee();
    }

    @PostMapping( "/addEmployee")
    @ResponseBody
    public Employee addEmployee(@RequestBody EmployeeRequets newEmployee)
    {
        return employeeService.addEmployee(newEmployee);
    }
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequets employeeRequets)
    {
        return employeeService.updateEmployee(id,employeeRequets);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmmployee(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
    }
}
