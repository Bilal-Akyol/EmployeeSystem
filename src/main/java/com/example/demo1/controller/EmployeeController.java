package com.example.demo1.controller;

import com.example.demo1.mapstruct.dto.EmployeeDto;
import com.example.demo1.sevice.EmployeeService;
import jakarta.validation.Valid;
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
    public List<EmployeeDto> getAllEmployee()
    {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public EmployeeDto getIdEmployee(@PathVariable Long id)
    {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping( "/addEmployee")
    public EmployeeDto addEmployee(@Valid @RequestBody EmployeeDto newEmployee)
    {
        return employeeService.createEmployee(newEmployee);
    }
    @PutMapping("/update")
    public EmployeeDto updateEmployee(@Valid  @RequestBody EmployeeDto eupdateEmployeeDto)
    {
        return employeeService.updateEmployee(eupdateEmployeeDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteEmmployee(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
    }
}
