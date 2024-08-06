package com.example.demo1.mapstruct.dto;

import com.example.demo1.entity.entities.Employee;
import com.example.demo1.entity.enums.ContractType;
import com.example.demo1.entity.enums.Level;
import com.example.demo1.entity.enums.Team;
import com.example.demo1.entity.enums.WorkType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {


    private Long id;

    @Size(min = 2)
    @NotBlank(message = "İsim boş olamaz")
    private String firstName;

    @Size(min = 2)
    @NotBlank(message = "Soy isim boş olamaz")
    private String lastName;


    private EmployeeDto director;


    private Level level;


    @Size(min = 11,max =11 ,message = "Telefon numarasını başına 0 yazınız")
    @NotBlank(message = "Lütfen size ait olan bir telefon numarası giriniz")
    private String phoneNumber;



    @Email(message = "Lütfen size ait bir mail giriniz")
    private String eMail;



    @Enumerated(EnumType.STRING)
    @NotNull(message = "Lütfen work type (Uzaktan, Ofisten, Hibrit) seçeneklerinden birini yazınız")

    private WorkType workType;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Lütfen bu alanı kontrat tipini  yazınız")
    private ContractType contractType;


    @Enumerated(EnumType.STRING)
    @NotNull(message = "Lütfen ait olduğunuz takımı yazınız")

    private Team team;

    @Enumerated(EnumType.STRING)
    @PastOrPresent(message = "Sözleşme başlangıç tarihine ileri bir tarih yazamazsın")
    private LocalDate startDate;

    @Enumerated(EnumType.STRING)
    @FutureOrPresent(message = "Sözleşme bitiş tarihine geçmiş bir tarih yazamazsın")
    private LocalDate endDate;


    private PersonalInformationDto personalInformation;


    private OtherInformationDto otherInformation;



    private List<ProjectDto> projects;



}
