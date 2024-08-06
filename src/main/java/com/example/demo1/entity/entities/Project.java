package com.example.demo1.entity.entities;

import com.example.demo1.entity.enums.ProjectType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Project-Name")
    private String projectName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Proje-Type")
    private ProjectType projectType;

    @Column(name = "Department")
    private String department;

    @Column(name = "VPNusername")
    private String vPNUsername;

    @Column(name = "VPNpassword")
    private String vPNpassword;

    @Column(name = "EnvironmentInformation")
    private String EnvironmentInformation;

    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )

    private List<Employee> employees;



}
