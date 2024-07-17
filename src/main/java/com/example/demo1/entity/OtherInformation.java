package com.example.demo1.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "OtherInformation")
public class OtherInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "address")
    private String address;

    @JoinColumn(name = "Bank-Name")
    private String bankName;

    @JoinColumn(name = "Iban-Number")
    private String ibanNumber;

    @JoinColumn(name = "EmergencyContactName")
    private String emergencyContactName;

    @JoinColumn(name = "EmergencyContactNumber")
    private String emergencyContactNumber;

    @OneToOne
    @JoinColumn(name = "user-id")
    @JsonManagedReference
    private Employee employee;


}
