package com.example.demo1.sevice;

import com.example.demo1.entity.Employee;
import com.example.demo1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private  EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }
    public Employee addEmployee(Employee newEmployee){
        return employeeRepository.save(newEmployee);
    }

    public Employee updateEmployee(Long id, Employee employee)
    {
        Employee updateEmployee= employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("İd ait kişisel bilgiler bulunamadı"));
        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setDirector(employee.getDirector());
        updateEmployee.setLevel(employee.getLevel());
        updateEmployee.setPhoneNumber(employee.getPhoneNumber());
        updateEmployee.setEMail(updateEmployee.getEMail());
        updateEmployee.setWorkType(employee.getWorkType());
        updateEmployee.setContractType(employee.getContractType());
        updateEmployee.setTeam(employee.getTeam());
        updateEmployee.setStartDate(employee.getStartDate());
        updateEmployee.setEndDate(employee.getEndDate());
        return employeeRepository.save(updateEmployee);
    }


}
