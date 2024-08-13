package com.example.demo1.controller;

import com.example.demo1.mapstruct.dto.EmployeeDto;
import com.example.demo1.sevice.EmployeeService;
import com.example.demo1.validation.EmployeeValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeValidator employeeValidator;


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(employeeValidator);
    }


    public EmployeeController(EmployeeService employeeService, EmployeeValidator employeeValidator) {
        this.employeeService = employeeService;
        this.employeeValidator= employeeValidator;
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
    public void deleteEmployee(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
    }
}
