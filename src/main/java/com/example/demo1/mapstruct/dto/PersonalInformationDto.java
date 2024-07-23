package com.example.demo1.mapstruct.dto;

import com.example.demo1.entity.entities.Employee;
import com.example.demo1.entity.enums.Gender;
import com.example.demo1.entity.enums.MaritalStatus;
import com.example.demo1.entity.enums.Military;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalInformationDto {

    private Long id;

    private LocalDate birthDate;

    private String nationalId;

    private Military military;

    private Gender gender;

    private MaritalStatus maritalStatus;

    private Employee employee;
}
