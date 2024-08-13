package com.example.demo1.entity.entities;

import com.example.demo1.entity.enums.ContractType;
import com.example.demo1.entity.enums.Level;
import com.example.demo1.entity.enums.Team;
import com.example.demo1.entity.enums.WorkType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "Director")
    private Employee director;


    @Enumerated(EnumType.STRING)
    @Column(name = "Level")
    private Level level;


    @NotBlank
    @Column(name = "Phone-Number", unique = true)
    private String phoneNumber;

    @NotBlank
    @Column(name = "email", unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "Work-Type")
    private WorkType workType;

    @Enumerated(EnumType.STRING)
    @Column(name = "Contract-Type")
    private ContractType contractType;

    @Enumerated(EnumType.STRING)
    @Column(name = "Team")
    private Team team;

    @Column(name = "Start-Date")
    private LocalDate startDate;

    @Column(name = "End-Date")
    private LocalDate endDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_information_id", referencedColumnName = "id")
    private PersonalInformation personalInformation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "other_information_id", referencedColumnName = "id")
    private OtherInformation otherInformation;

    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )

    private List<Project> project;


}
