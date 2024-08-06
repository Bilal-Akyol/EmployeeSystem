package com.example.demo1.sevice;

import com.example.demo1.entity.entities.Employee;
import com.example.demo1.entity.entities.OtherInformation;
import com.example.demo1.entity.entities.PersonalInformation;
import com.example.demo1.mapstruct.dto.EmployeeDto;
import com.example.demo1.mapstruct.mappers.MapStructMapper;
import com.example.demo1.repository.EmployeeRepository;
import com.example.demo1.repository.OtherInformationRepository;
import com.example.demo1.repository.PersonalInformationRepository;
import com.example.demo1.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private MapStructMapper mapStructMapper;


    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    PersonalInformationRepository personalInformationRepository;
    @Autowired
    OtherInformationRepository otherInformationRepository;

    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(mapStructMapper::employeeToDto)
                .collect(Collectors.toList());
    }


    public EmployeeDto getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(mapStructMapper::employeeToDto).orElse(null);
    }

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = mapStructMapper.dtoToEmployee(employeeDto);

        if (employeeDto.getPersonalInformation() != null && employeeDto.getPersonalInformation().getId() != null) {
            Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(employeeDto.getPersonalInformation().getId());
            personalInformationOptional.ifPresent(employee::setPersonalInformation);
        }
        if (employeeDto.getOtherInformation() != null && employeeDto.getOtherInformation().getId() != null) {
            Optional<OtherInformation> otherInformationOptional = otherInformationRepository.findById(employeeDto.getOtherInformation().getId());
            otherInformationOptional.ifPresent(employee::setOtherInformation);
        }

        employee = employeeRepository.save(employee);
        return mapStructMapper.employeeToDto(employee);
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeDto.getId());

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setDirector(mapStructMapper.dtoToEmployee(employeeDto.getDirector()));
            employee.setLevel(employeeDto.getLevel());
            employee.setPhoneNumber(employeeDto.getPhoneNumber());
            employee.setEMail(employeeDto.getEMail());
            employee.setWorkType(employeeDto.getWorkType());
            employee.setContractType(employeeDto.getContractType());
            employee.setTeam(employeeDto.getTeam());
            employee.setStartDate(employeeDto.getStartDate());
            employee.setEndDate(employeeDto.getEndDate());

            if (employeeDto.getPersonalInformation() != null && employeeDto.getPersonalInformation().getId() != null) {
                Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(employeeDto.getPersonalInformation().getId());
                personalInformationOptional.ifPresent(employee::setPersonalInformation);
            }

            if (employeeDto.getOtherInformation() != null && employeeDto.getOtherInformation().getId() != null) {
                Optional<OtherInformation> otherInformationOptional = otherInformationRepository.findById(employeeDto.getOtherInformation().getId());
                otherInformationOptional.ifPresent(employee::setOtherInformation);
            }

            if (employeeDto.getProjects() != null) {
                employee.setProject(employeeDto.getProjects().stream()
                        .map(mapStructMapper::dtoToProject)
                        .collect(Collectors.toList()));
            } else {
                employee.setProject(new ArrayList<>());
            }

            employee = employeeRepository.save(employee);
            return mapStructMapper.employeeToDto(employee);
        } else {
            return null;
        }
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}

