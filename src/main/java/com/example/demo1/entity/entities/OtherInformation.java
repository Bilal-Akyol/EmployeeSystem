package com.example.demo1.entity.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "other_information")
public class OtherInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "Bank-Name")
    private String bankName;

    @Column(name = "Iban-Number")
    private String ibanNumber;

    @Column(name = "EmergencyContactName")
    private String emergencyContactName;

    @Column(name = "EmergencyContactNumber")
    private String emergencyContactNumber;



}
