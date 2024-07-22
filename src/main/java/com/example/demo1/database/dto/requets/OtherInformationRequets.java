package com.example.demo1.database.dto.requets;

import com.example.demo1.entity.entities.Employee;
import com.example.demo1.entity.enums.Gender;
import com.example.demo1.entity.enums.MaritalStatus;
import com.example.demo1.entity.enums.Military;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherInformationRequets {
    private String address;

    private String bankName;

    private String ibanNumber;

    private String emergencyContactName;

    private String emergencyContactNumber;

    private Employee employee;
}
