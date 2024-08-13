package com.example.demo1.mapstruct.mappers;

import com.example.demo1.entity.entities.Employee;
import com.example.demo1.entity.entities.OtherInformation;
import com.example.demo1.entity.entities.PersonalInformation;
import com.example.demo1.entity.entities.Project;
import com.example.demo1.mapstruct.dto.EmployeeDto;
import com.example.demo1.mapstruct.dto.OtherInformationDto;
import com.example.demo1.mapstruct.dto.PersonalInformationDto;
import com.example.demo1.mapstruct.dto.ProjectDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapStructMapper{


    public EmployeeDto employeeToDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setDirector(employeeDto.getDirector());
        employeeDto.setLevel(employee.getLevel());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setWorkType(employee.getWorkType());
        employeeDto.setContractType(employee.getContractType());
        employeeDto.setTeam(employee.getTeam());
        employeeDto.setStartDate(employee.getStartDate());
        employeeDto.setEndDate(employee.getEndDate());
        employeeDto.setPersonalInformation(personalInformationToDto(employee.getPersonalInformation()));
        employeeDto.setOtherInformation(otherInformationToDto(employee.getOtherInformation()));
        employeeDto.setProjects(employee.getProject().stream().map(this::projectToDto).collect(Collectors.toList()));

        return employeeDto;
    }

    public Employee dtoToEmployee(EmployeeDto employeeDto) {
        if (employeeDto == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setDirector(dtoToEmployee(employeeDto.getDirector()));
        employee.setLevel(employeeDto.getLevel());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setEmail(employeeDto.getEmail());
        employee.setWorkType(employeeDto.getWorkType());
        employee.setContractType(employeeDto.getContractType());
        employee.setTeam(employeeDto.getTeam());
        employee.setStartDate(employeeDto.getStartDate());
        employee.setEndDate(employeeDto.getEndDate());

        if (employeeDto.getProjects() != null) {
            employee.setProject(employeeDto.getProjects().stream()
                    .map(this::dtoToProject)
                    .collect(Collectors.toList()));
        } else {
            employee.setProject(new ArrayList<>());
        }

        employee.setPersonalInformation(dtoToPersonalInformation(employeeDto.getPersonalInformation()));
        employee.setOtherInformation(dtoToOtherInformation(employeeDto.getOtherInformation()));

        return employee;
    }



    public OtherInformationDto otherInformationToDto(OtherInformation otherInformation) {
        if (otherInformation == null) {
            return null;
        }

        OtherInformationDto otherInformationDto = new OtherInformationDto();
        otherInformationDto.setId(otherInformation.getId());
        otherInformationDto.setAddress(otherInformation.getAddress());
        otherInformationDto.setBankName(otherInformation.getBankName());
        otherInformationDto.setIbanNumber(otherInformation.getIbanNumber());
        otherInformationDto.setEmergencyContactName(otherInformation.getEmergencyContactName());
        otherInformationDto.setEmergencyContactNumber(otherInformation.getEmergencyContactNumber());

        return otherInformationDto;
    }

    public OtherInformation dtoToOtherInformation(OtherInformationDto otherInformationDto) {
        if (otherInformationDto == null) {
            return null;
        }

        OtherInformation otherInformation = new OtherInformation();
        otherInformation.setId(otherInformationDto.getId());
        otherInformation.setAddress(otherInformationDto.getAddress());
        otherInformation.setBankName(otherInformationDto.getBankName());
        otherInformation.setIbanNumber(otherInformationDto.getIbanNumber());
        otherInformation.setEmergencyContactName(otherInformationDto.getEmergencyContactName());
        otherInformation.setEmergencyContactNumber(otherInformationDto.getEmergencyContactNumber());

        return otherInformation;
    }


    public PersonalInformationDto personalInformationToDto(PersonalInformation personalInformation) {
        if (personalInformation == null) {
            return null;
        }

        PersonalInformationDto personalInformationDto = new PersonalInformationDto();
        personalInformationDto.setId(personalInformation.getId());
        personalInformationDto.setBirthDate(personalInformation.getBirthDate());
        personalInformationDto.setNationalId(personalInformation.getNationalId());
        personalInformationDto.setMilitary(personalInformation.getMilitary());
        personalInformationDto.setGender(personalInformation.getGender());
        personalInformationDto.setMaritalStatus(personalInformation.getMaritalStatus());

        return personalInformationDto;
    }

    public PersonalInformation dtoToPersonalInformation(PersonalInformationDto personalInformationDto) {
        if (personalInformationDto == null) {
            return null;
        }

        PersonalInformation personalInformation = new PersonalInformation();
        personalInformation.setId(personalInformationDto.getId());
        personalInformation.setBirthDate(personalInformationDto.getBirthDate());
        personalInformation.setNationalId(personalInformationDto.getNationalId());
        personalInformation.setMilitary(personalInformationDto.getMilitary());
        personalInformation.setGender(personalInformationDto.getGender());
        personalInformation.setMaritalStatus(personalInformationDto.getMaritalStatus());

        return personalInformation;
    }


    public ProjectDto projectToDto(Project project) {
        if (project == null) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setProjectName(project.getProjectName());
        projectDto.setProjectType(project.getProjectType());
        projectDto.setDepartment(project.getDepartment());
        projectDto.setVPNUsername(project.getVPNUsername());
        projectDto.setVPNpassword(project.getVPNpassword());
        projectDto.setEnvironmentInformation(project.getEnvironmentInformation());

        if (project.getEmployees() != null) {
            List<Long> employeeIds = project.getEmployees().stream()
                    .map(Employee::getId)
                    .collect(Collectors.toList());
            projectDto.setEmployeeIds(employeeIds);
        } else {
            projectDto.setEmployeeIds(new ArrayList<>());
        }

        return projectDto;
    }

    public Project dtoToProject(ProjectDto projectDto) {
        if (projectDto == null) {
            return null;
        }

        Project project = new Project();
        project.setId(projectDto.getId());
        project.setProjectName(projectDto.getProjectName());
        project.setProjectType(projectDto.getProjectType());
        project.setDepartment(projectDto.getDepartment());
        project.setVPNUsername(projectDto.getVPNUsername());
        project.setVPNpassword(projectDto.getVPNpassword());
        project.setEnvironmentInformation(projectDto.getEnvironmentInformation());

        return project;
    }

}
