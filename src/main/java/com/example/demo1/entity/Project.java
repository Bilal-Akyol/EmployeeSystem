package com.example.demo1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

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

    @ManyToOne
    @JoinColumn(name = "employee-id")
    @JsonBackReference
    private Employee employee;


}
