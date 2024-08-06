package com.example.demo1.entity.entities;

import com.example.demo1.entity.enums.Gender;
import com.example.demo1.entity.enums.MaritalStatus;
import com.example.demo1.entity.enums.Military;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "personal-infermation")
public class PersonalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Birth-Date")
    private LocalDate birthDate;

    @NotBlank
    @Column(name = "National-Id",unique = true)
    private String nationalId;

    @Enumerated(EnumType.STRING)
    @Column(name = "Military-Service")
    private Military military;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "Marital-Status")
    private MaritalStatus maritalStatus;




}
