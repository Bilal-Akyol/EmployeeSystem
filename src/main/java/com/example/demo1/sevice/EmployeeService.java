package com.example.demo1.sevice;

import com.example.demo1.entity.Employee;
import com.example.demo1.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
}
