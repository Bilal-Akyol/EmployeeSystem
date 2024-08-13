package com.example.demo1.mapstruct.dto;

import com.example.demo1.entity.enums.ContractType;
import com.example.demo1.entity.enums.Level;
import com.example.demo1.entity.enums.Team;
import com.example.demo1.entity.enums.WorkType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {


    private Long id;


    private String firstName;

    private String lastName;


    private EmployeeDto director;


    private Level level;


    private String phoneNumber;



    @Email(message = "Lütfen size ait bir mail giriniz")
    private String email;



    @Enumerated(EnumType.STRING)
    private WorkType workType;

    @Enumerated(EnumType.STRING)
    private ContractType contractType;


    @Enumerated(EnumType.STRING)


    private Team team;

    @Enumerated(EnumType.STRING)

    private LocalDate startDate;

    @Enumerated(EnumType.STRING)

    private LocalDate endDate;


    private PersonalInformationDto personalInformation;


    private OtherInformationDto otherInformation;



    private List<ProjectDto> projects;



}
