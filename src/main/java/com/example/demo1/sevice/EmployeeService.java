package com.example.demo1.sevice;

import com.example.demo1.mapstruct.dto.EmployeeDto;
import com.example.demo1.mapstruct.mappers.MapStructMapper;
import com.example.demo1.repository.EmployeeRepository;
import com.example.demo1.entity.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    private MapStructMapper mapStructMapper;


    public EmployeeService(EmployeeRepository employeeRepository, MapStructMapper mapStructMapper) {
        this.employeeRepository = employeeRepository;
        this.mapStructMapper=mapStructMapper;


    }

    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeeResponses = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDto responseItem = new EmployeeDto();
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

    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee= mapStructMapper.employeeToDto(employeeDto);
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setDirector(employeeDto.getDirector());
        employee.setLevel(employeeDto.getLevel());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setEMail(employeeDto.getEMail());
        employee.setWorkType(employeeDto.getWorkType());
        employee.setContractType(employeeDto.getContractType());
        employee.setTeam(employeeDto.getTeam());
        employee.setStartDate(employeeDto.getStartDate());
        employee.setEndDate(employeeDto.getEndDate());
        employee.setPersonalInformation(employeeDto.getPersonalInformation());
        employee.setOtherInformation(employeeDto.getOtherInformation());
        employee.setProject(employeeDto.getProject());

        employee = employeeRepository.save(employee);
        return mapStructMapper.employeeDto(employee);
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee updateEmployee = employeeRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("İd ait kişisel bilgiler bulunamadı"));
        updateEmployee.setFirstName(employeeDto.getFirstName());
        updateEmployee.setLastName(employeeDto.getLastName());
        updateEmployee.setDirector(employeeDto.getDirector());
        updateEmployee.setLevel(employeeDto.getLevel());
        updateEmployee.setPhoneNumber(employeeDto.getPhoneNumber());
        updateEmployee.setEMail(employeeDto.getEMail());
        updateEmployee.setWorkType(employeeDto.getWorkType());
        updateEmployee.setContractType(employeeDto.getContractType());
        updateEmployee.setTeam(employeeDto.getTeam());
        updateEmployee.setStartDate(employeeDto.getStartDate());
        updateEmployee.setEndDate(employeeDto.getEndDate());
        updateEmployee.setPersonalInformation(employeeDto.getPersonalInformation());
        updateEmployee.setOtherInformation(employeeDto.getOtherInformation());
        updateEmployee.setProject(employeeDto.getProject());
        updateEmployee = employeeRepository.save(updateEmployee);
        return mapStructMapper.employeeDto(updateEmployee);

    }
    public void deleteEmployee(Long id)
    {

        employeeRepository.deleteById(id);
    }


}
