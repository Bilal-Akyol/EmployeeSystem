package com.example.demo1.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "Project-Name")
    private String projectName;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "Proje-Type")
    private ProjectType projectType;

    @JoinColumn(name = "Department")
    private String department;

    @JoinColumn(name = "VPNusername")
    private String vPNUsername;

    @JoinColumn(name = "VPNpassword")
    private String vPNpassword;

    @JoinColumn(name = "EnvironmentInformation")
    private String EnvironmentInformation;

    @ManyToOne
    @JoinColumn(name = "user-id")
    @JsonManagedReference
    private Employee employee;


}
