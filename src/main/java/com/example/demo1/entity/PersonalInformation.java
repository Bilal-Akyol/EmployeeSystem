package com.example.demo1.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Personal-Infermation")
public class PersonalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "Birth-Date")
    private LocalDate birthDate;

    @NotBlank
    @JoinColumn(name = "National-Id",unique = true)
    private String nationalId;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "Military-Service")
    private Military military;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "Gender")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "Marital-Status")
    private MaritalStatus maritalStatus;

    @OneToOne
    @JoinColumn(name = "user-id")
    @JsonManagedReference
    private Employee employee;



}
