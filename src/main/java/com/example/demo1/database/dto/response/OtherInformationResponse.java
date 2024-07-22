package com.example.demo1.database.dto.response;

import com.example.demo1.entity.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OtherInformationResponse {

    private Long id;

    private String address;

    private String bankName;

    private String ibanNumber;

    private String emergencyContactName;

    private String emergencyContactNumber;

    private Employee employee;
}
