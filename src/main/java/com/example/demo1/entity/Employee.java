package com.example.demo1.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @JsonProperty (value = "EmployeeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "firstName")
    private String firstName;

    @JsonProperty(value = "lastName")
    private String lastName;


    @JoinColumn(name = "Director")
    @OneToOne()
    private Employee director;

    @Enumerated(EnumType.STRING)
    @JsonProperty(value = "Level")
    private Level level;


    @NotBlank
    @JoinColumn(name = "Phone-Number", unique = true)
    private String phoneNumber;

    @Email
    @NotBlank
    @JoinColumn(name = "Email",unique = true)
    private String eMail;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "Work-Type")
    private WorkType workType;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "Contract-Type")
    private ContractType contractType;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "Team")
    private Team team;

    @JoinColumn(name = "Start-Date")
    private LocalDate startDate;

    @Column(name = "End-Date")
    private LocalDate endDate;

    @OneToOne(mappedBy = "employee", fetch =FetchType.LAZY)
    @JsonManagedReference
    private PersonalInformation personalInfermation;

    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonManagedReference
    private OtherInformation otherInformation;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Project> project;

}
