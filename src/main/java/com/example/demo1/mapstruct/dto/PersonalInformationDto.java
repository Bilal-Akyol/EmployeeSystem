package com.example.demo1.mapstruct.dto;

import com.example.demo1.entity.entities.Employee;
import com.example.demo1.entity.enums.Gender;
import com.example.demo1.entity.enums.MaritalStatus;
import com.example.demo1.entity.enums.Military;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(min = 11,max = 11,message = "Lütfen 11 haneli tc kilik numaranızı giriniz")
    @NotBlank(message = "Kimlik numarası zorunludur, Lütfen kimlik numaranızı yazınız")
    private String nationalId;

    @NotBlank(message = "Askerlik alanı boş bırakılamaz, Lütfen doldurunuz")
    private Military military;

    private Gender gender;

    private MaritalStatus maritalStatus;

    private Employee employee;
}
