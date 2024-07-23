package com.example.demo1.mapstruct.mappers;

import com.example.demo1.entity.entities.Employee;
import com.example.demo1.entity.entities.OtherInformation;
import com.example.demo1.entity.entities.PersonalInformation;
import com.example.demo1.entity.entities.Project;
import com.example.demo1.mapstruct.dto.EmployeeDto;
import com.example.demo1.mapstruct.dto.OtherInformationDto;
import com.example.demo1.mapstruct.dto.PersonalInformationDto;
import com.example.demo1.mapstruct.dto.ProjectDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {


    EmployeeDto employeeDto(Employee employee);
    Employee employeeToDto(EmployeeDto employeeDto);

    OtherInformationDto otherInformationDto(OtherInformation otherInformation);
    OtherInformation otherInformationToDto(OtherInformationDto otherInformationDto);

    PersonalInformationDto personalInformationDto(PersonalInformation personalInformation);
    PersonalInformation personalInformationToDto(PersonalInformationDto personalInformationDto);

    ProjectDto projectDto(Project project);
    Project projectToDto(ProjectDto projectDto);

}
