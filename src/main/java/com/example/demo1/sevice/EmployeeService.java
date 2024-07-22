package com.example.demo1.sevice;

import com.example.demo1.database.dto.requets.EmployeeRequets;
import com.example.demo1.database.dto.response.EmployeeResponse;
import com.example.demo1.entity.entities.Employee;
import com.example.demo1.database.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponse> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeResponse responseItem = new EmployeeResponse();
            responseItem.setId(employee.getId());
            responseItem.setFirstName(employee.getFirstName());
            responseItem.setLastName(employee.getLastName());
            responseItem.setDirector(employee.getDirector());
            responseItem.setLevel(employee.getLevel());
            responseItem.setPhoneNumber(employee.getPhoneNumber());
            responseItem.setEMail(employee.getEMail());
            responseItem.setWorkType(employee.getWorkType());
            responseItem.setContractType(employee.getContractType());
            responseItem.setTeam(employee.getTeam());
            responseItem.setStartDate(employee.getStartDate());
            responseItem.setEndDate(employee.getEndDate());
            responseItem.setPersonalInformation(employee.getPersonalInformation());
            responseItem.setOtherInformation(employee.getOtherInformation());
            responseItem.setProject(employee.getProject());
            employeeResponses.add(responseItem);
        }
        return employeeResponses;
    }

    public Employee addEmployee(EmployeeRequets employeeRequets) {
        Employee employee=new Employee();
        employee.setFirstName(employeeRequets.getFirstName());
        employee.setLastName(employeeRequets.getLastName());
        employee.setDirector(employeeRequets.getDirector());
        employee.setLevel(employeeRequets.getLevel());
        employee.setPhoneNumber(employeeRequets.getPhoneNumber());
        employee.setEMail(employeeRequets.getEMail());
        employee.setWorkType(employeeRequets.getWorkType());
        employee.setContractType(employeeRequets.getContractType());
        employee.setTeam(employeeRequets.getTeam());
        employee.setStartDate(employeeRequets.getStartDate());
        employee.setEndDate(employeeRequets.getEndDate());
        employee.setPersonalInformation(employeeRequets.getPersonalInformation());
        employee.setOtherInformation(employeeRequets.getOtherInformation());
        employee.setProject(employeeRequets.getProject());


        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, EmployeeRequets emoloyeeRequets) {
        Employee updateEmployee = employeeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("İd ait kişisel bilgiler bulunamadı"));
        updateEmployee.setFirstName(emoloyeeRequets.getFirstName());
        updateEmployee.setLastName(emoloyeeRequets.getLastName());
        updateEmployee.setDirector(emoloyeeRequets.getDirector());
        updateEmployee.setLevel(emoloyeeRequets.getLevel());
        updateEmployee.setPhoneNumber(emoloyeeRequets.getPhoneNumber());
        updateEmployee.setEMail(emoloyeeRequets.getEMail());
        updateEmployee.setWorkType(emoloyeeRequets.getWorkType());
        updateEmployee.setContractType(emoloyeeRequets.getContractType());
        updateEmployee.setTeam(emoloyeeRequets.getTeam());
        updateEmployee.setStartDate(emoloyeeRequets.getStartDate());
        updateEmployee.setEndDate(emoloyeeRequets.getEndDate());
        updateEmployee.setPersonalInformation(emoloyeeRequets.getPersonalInformation());
        updateEmployee.setOtherInformation(emoloyeeRequets.getOtherInformation());
        updateEmployee.setProject(emoloyeeRequets.getProject());
        return employeeRepository.save(updateEmployee);
    }
    public void deleteEmployee(Long id)
    {

        employeeRepository.delete(employeeRepository.findById(id).get());
    }


}
